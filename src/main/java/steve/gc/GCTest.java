package steve.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author steve
 */
public class GCTest {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<ATest> weakReference = new WeakReference<>(new ATest());
        byte[] buff1 = new byte[1024*1024];
        SoftReference<byte[]> softReference = new SoftReference<>(buff1);
        PhantomReference<ATest> phantomReference = new PhantomReference<>(new ATest(), new ReferenceQueue<>());
        buff1 = null;
        byte[] buff2 = new byte[1024*1024*500];
        byte[] buff3 = new byte[1024*1024*500];
        byte[] buff4 = new byte[1024*1024*500];
        byte[] buff5 = new byte[1024*1024*500];
        byte[] buff6 = new byte[1024*1024*500];
        byte[] buff7 = new byte[1024*1024*500];
        byte[] buff8 = new byte[1024*1024*500];
        byte[] buff9 = new byte[1024*1024*500];
        System.gc();
        System.out.println(weakReference.get());
        System.out.println(phantomReference.get());
        System.out.println(softReference.get());
    }
}
