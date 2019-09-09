package steve.nio.bio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author steve
 */
public class BIOFileReaderThread implements Runnable {
    String path;
    int sleepMillis;
    String name;

    private void readFile(String file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[5];
            int cursor = 0;
            System.out.println(fileInputStream.available());
            while (cursor < fileInputStream.available()) {
                System.out.println(name + " is reading....");
                int read = fileInputStream.read(bytes);
                System.out.println(new String(bytes).substring(0, read));
                cursor += read;
                System.out.println(cursor);
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
