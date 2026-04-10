import java.util.*;

/*
 * Problem: Count total commas used when writing numbers from 1 to n
 *
 * Approach:
 * - Numbers are grouped based on how many commas they contain:
 *   1) 1,000 to 999,999       → 1 comma each
 *   2) 1,000,000 to 999,999,999 → 2 commas each
 * - Instead of iterating every number, we count how many numbers
 *   fall into each range up to n and multiply by comma count.
 *
 * Example:
 * n = 1,234,567
 * - From 1000 to 999999 → all have 1 comma
 * - From 1000000 to n → all have 2 commas
 *
 * Time Complexity: O(log n)
 * - Only checking ranges, not iterating over all numbers
 *
 * Space Complexity: O(1)
 * - No extra space used
 */

public class CountCommas {

    public static int countCommas(int n) {
        int count = 0;

        // Range 1: 1000 to 999999 → 1 comma each
        if (n >= 1000) {
            int upper = Math.min(n, 999999);
            count += (upper - 1000 + 1);
        }

        // Range 2: 1000000 to 999999999 → 2 commas each
        if (n >= 1000000) {
            int upper = Math.min(n, 999999999);
            count += (upper - 1000000 + 1) * 2;
        }

        // (Optional) Extend for larger numbers if needed:
        // 1,000,000,000 → 3 commas, etc.

        return count;
    }

    public static void main(String[] args) {
        int n = 1234567;

        System.out.println("Total commas from 1 to " + n + " = " + countCommas(n));
    }
}