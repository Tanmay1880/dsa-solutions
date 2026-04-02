/**
 * Problem: LeetCode 231 - Power of Two
 *
 * Approach:
 * - A power of two has exactly one set bit
 * - Use (n & (n - 1)) to remove the lowest set bit
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class PowerOfTwoChecker {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));  // true
        System.out.println(isPowerOfTwo(10)); // false
    }
}