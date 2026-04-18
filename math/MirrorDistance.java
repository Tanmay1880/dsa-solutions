import java.util.*;

/*
 * Problem: Mirror Distance
 *
 * Definition:
 * - Reverse the digits of a number
 * - Return absolute difference between original and reversed number
 *
 * Example:
 * n = 123 → reverse = 321 → |123 - 321| = 198
 *
 * Approach:
 * - Reverse digits using modulo and division
 * - Use long to avoid overflow
 * - Return absolute difference
 *
 * Time Complexity: O(d)  (d = number of digits)
 * Space Complexity: O(1)
 */

public class MirrorDistance {

    public static int mirrorDistance(int n) {
        long reversed = reverse(n);
        return (int) Math.abs((long) n - reversed);
    }

    private static long reverse(int x) {
        long temp = 0;

        int num = Math.abs(x); // handle negative safely

        while (num > 0) {
            temp = temp * 10 + (num % 10);
            num /= 10;
        }

        return x < 0 ? -temp : temp;
    }

    public static void main(String[] args) {
        System.out.println(mirrorDistance(123));   // 198
        System.out.println(mirrorDistance(120));   // 99
        System.out.println(mirrorDistance(-456));  // 198
    }
}