import java.util.*;

/*
 * Problem: Count total commas used from 1 to n
 *
 * Approach:
 * - Numbers gain 1 comma for every 3 extra digits after 3 digits
 * - We iterate over ranges:
 *   [1000, 999999] → 1 comma
 *   [1000000, 999999999] → 2 commas
 *   ...
 * - For each range:
 *      count how many numbers exist up to n
 *      multiply by comma count
 *
 * Time Complexity: O(log₁₀(n)) ≈ O(log n)
 * Space Complexity: O(1)
 */

public class CountCommasII {

    public static long countCommas(long n) {
        long count = 0;

        long start = 1000;   // first number with comma
        int commas = 1;

        while (start <= n) {
            long end = start * 1000 - 1;

            long upper = Math.min(n, end);

            count += (upper - start + 1) * commas;

            start *= 1000;
            commas++;
        }

        return count;
    }

    public static void main(String[] args) {
        long n = 1002;
        System.out.println(countCommas(n)); // 3

        n = 998;
        System.out.println(countCommas(n)); // 0

        n = 1234567890123L;
        System.out.println(countCommas(n));
    }
}