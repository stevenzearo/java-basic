package steve.nio.bio;

import steve.nio.nio.FileChannelThread;

/**
 * @author steve
 */
public class BIOFileReaderTest {
    public static void main(String[] args) {
        String path = "C:\\Users\\steve\\IdeaProjects\\java-basic\\src\\main\\java\\steve\\nio\\test.txt";
        BIOFileReaderThread bioReader1 = new BIOFileReaderThread();
        BIOFileReaderThread bioReader2 = new BIOFileReaderThread();
        bioReader1.path = path;
        bioReader1.name = "bioReader1";
        bioReader1.sleepMillis = 20;

        bioReader2.name = "bioReader2";
        bioReader2.path = path;
        bioReader2.sleepMillis = 25;

        Thread thread1 = new Thread(bioReader1);
        Thread thread2 = new Thread(bioReader2);
        thread1.start();
        thread2.start();
    }
}
