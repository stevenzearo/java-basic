package steve.nio.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author steve
 */
public class FileChannelThread implements Runnable {
    String path;
    int sleepMillis;
    String name;

    private void readFile(String file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel fileChannel = fileInputStream.getChannel();
            long size = fileChannel.size();
            System.out.println(size);
            ByteBuffer buffer = ByteBuffer.allocate(5);
            while (fileChannel.position() < size) {
                int read = fileChannel.read(buffer);
                System.out.println(name + " is reading....");
                System.out.println(new String(buffer.array()).substring(0, read));
                buffer.clear();
                System.out.println(fileChannel.position());
                Thread.sleep(sleepMillis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        readFile(path);
    }
}
