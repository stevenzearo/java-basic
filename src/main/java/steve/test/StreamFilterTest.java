package steve.test;

import java.util.Arrays;

/**
 * @author steve
 */
public class StreamFilterTest {
    public static void main(String[] args) {
        Integer[] integers = new Integer[] {1, 3, 2, 5, 8, 7};
        Arrays.stream(integers).filter(a -> a > 3).forEach(System.out::println); //filter结果为true则留下
    }
}
