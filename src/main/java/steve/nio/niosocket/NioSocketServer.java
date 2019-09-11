package steve.nio.niosocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * @author steve
 */
public class NioSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.socket().bind(new InetSocketAddress(9000));
        socketChannel.configureBlocking(false); // set this socket to nonblock
        Selector selector = Selector.open(); // get a selector to listen socket channel
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);// arg2: set listen trig event, selection key status: connection ready, accept ready, read ready, write ready.
        Handler handler = new Handler();
        while (true) {
            if (selector.select(3000) == 0) {
                System.out.println("wait for accept timeout......");
                continue;
            }
            System.out.println("procession accept......");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                try {
                    if (key.isAcceptable()) {
                        handler.handleAccept(key);
                    }

                    if (key.isReadable()) {
                        handler.handRead(key);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    iterator.remove();
                    continue;
                }
                iterator.remove();
            }
        }
    }

    private static class Handler {
        int bufferSize = 1024;

        public void handleAccept(SelectionKey key) throws IOException {
            SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));

        }

        public void handRead(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
            byteBuffer.clear();
            if (channel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                String receivedString = StandardCharsets.UTF_8.newDecoder().decode(byteBuffer).toString();
                System.out.println("received from client: " + receivedString);
                String sendString = "received data: " + receivedString;
                ByteBuffer wrap = ByteBuffer.wrap(sendString.getBytes());// get a byte buffer by arg.
                channel.write(wrap);
            }
            channel.close();

        }
    }
}
