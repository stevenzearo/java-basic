package steve.leetcode;

/**
 * @author steve
 */
public class Solution {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(-3));
    }
}
