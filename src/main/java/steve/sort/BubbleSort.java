package steve.sort;

import java.util.Arrays;

/**
 * @author steve
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = new int[] {2, 3, 1, 8, 7, 6, 9, 5, 4};
        Arrays.stream(ints).sorted().forEach(System.out::println);
    }
}
