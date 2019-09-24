package steve.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author steve
 */
public class LockTest {
    private static Lock lock = new ReentrantLock();
    private static volatile int a = 100;

    public static void sub() {
        if (a > 0) a --;
    }

    public static void method1() {
        try {
            lock.lock();
            sub();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        int times = 30;
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                method1();
                System.out.println(a);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                method1();
                System.out.println(a);
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                method1();
                System.out.println(a);
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                method1();
                System.out.println(a);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
//        ReentrantReadWriteLock.ReadLock
    }
}
