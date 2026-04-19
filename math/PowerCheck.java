import java.util.*;

/*
 * Problem: Check if y is a power of x
 *
 * Definition:
 * - y = x^k for some integer k >= 0
 *
 * Approach:
 * - Keep dividing y by x while divisible
 * - If we reach 1 → true
 *
 * Time Complexity: O(logₓ y)
 * Space Complexity: O(1)
 */

public class PowerCheck {

    public static boolean isPower(int x, int y) {

        // Edge cases
        if (x == 1) return y == 1;
        if (x <= 0 || y <= 0) return false;

        // Divide y by x repeatedly
        while (y % x == 0) {
            y /= x;
        }

        return y == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPower(2, 8));   // true
        System.out.println(isPower(3, 27));  // true
        System.out.println(isPower(2, 10));  // false
        System.out.println(isPower(1, 1));   // true
        System.out.println(isPower(1, 2));   // false
    }
}