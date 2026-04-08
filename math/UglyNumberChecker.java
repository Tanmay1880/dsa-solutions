/**
 * Problem: Ugly Number (LeetCode 263)
 *
 * An ugly number is a positive integer whose prime factors
 * are limited to 2, 3, and 5.
 *
 * Approach:
 * Continuously divide the number by 2, 3, and 5.
 * If the number becomes 1, it means it had no other prime factors.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class UglyNumberChecker {

    public static boolean isUgly(int n) {
        if (n <= 0) return false;

        int[] allowedPrimes = {2, 3, 5};

        for (int prime : allowedPrimes) {
            while (n % prime == 0) {
                n /= prime;
            }
        }

        return n == 1;
    }

    public static void main(String[] args) {
        int n = 14;
        System.out.println("Is Ugly: " + isUgly(n));
    }
}