package steve.constructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @author steve
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
       /* SecureRandom random = new SecureRandom();
        Double sum = 0d;
        int count0 = 0;
        int count6 = 0;
        int count1 = 0;
        for (int i = 0; i < 100000; i++) {
            double v = Math.sqrt(0.01) * random.nextGaussian() + 0.75d;
            while (v > 1d || v <= 0.5d) {
                v = random.nextGaussian();
            }
            if (v > 0.9) count1 += 1;
            if (v < 0.6) count0 += 1;
            sum += v;
            System.out.println(v);
        }
        System.out.println("---");
        System.out.println(count0);
        System.out.println(count1);
        System.out.println(sum / 10000);*/
        BufferedReader bufferedReader = Files.newBufferedReader(new File("basic/src/main/resources/test.txt").toPath());
        String s = bufferedReader.readLine();
        String[] split = s.split(", ");
        Arrays.stream(split).forEach(System.out::println);
    }
}
