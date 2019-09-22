package steve.nio.nio;

/**
 * @author steve
 * <p>
 * [reference from](https://www.cnblogs.com/wade-luffy/p/8448655.html)
 * FileChannel无法设置为非阻塞模式，它总是运行在阻塞模式下。
 */
public class FileChannelTest {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\steve\\IdeaProjects\\java-basic\\src\\main\\java\\steve\\nio\\test.txt";
        FileChannelThread channel1 = new FileChannelThread();
        FileChannelThread channel2 = new FileChannelThread();
        channel1.path = path;
        channel1.name = "channel1";
        channel1.sleepMillis = 20;

        channel2.name = "channel2";
        channel2.path = path;
        channel2.sleepMillis = 25;

        Thread thread1 = new Thread(channel1);
        Thread thread2 = new Thread(channel2);
        thread1.start();
        thread2.start();
    }
}
