package steve.nio.niosocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author steve
 */
public class NioSocketClient {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean connect = socketChannel.connect(new InetSocketAddress("localhost", 9000));
        if (connect) {
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
        while (selector.select(3000) > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                SocketChannel channel = (SocketChannel) next.channel();
                if (next.isConnectable()) {
                    if (channel.finishConnect()) {
                        channel.register(selector, SelectionKey.OP_READ);
                        channel.write(ByteBuffer.wrap("hello, world!".getBytes()));
                    }
                }
                if (next.isReadable()) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int read = channel.read(byteBuffer);
                    if (read > -1) {
                        String message = new String(byteBuffer.array()).substring(0, read);
                        System.out.println("get message: " + message);
                    }
                    next.cancel();
                    channel.close();
                }
                iterator.remove();
            }
        }

    }
}
