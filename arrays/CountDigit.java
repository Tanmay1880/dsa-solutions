import java.util.*;

/*
 * Problem: Count how many times a digit appears in an array of numbers
 *
 * Approach:
 * - Traverse each number
 * - Extract digits using modulo (%) and division (/)
 * - Compare each digit with target digit
 * - Special handling when number = 0
 *
 * Time Complexity: O(n * d)
 * - n = number of elements
 * - d = number of digits per number
 *
 * Space Complexity: O(1)
 */

public class CountDigit {

    public static int countDigit(int[] nums, int digit) {
        int count = 0;

        for (int num : nums) {

            // Special case: number itself is 0
            if (num == 0 && digit == 0) {
                count++;
                continue;
            }

            while (num > 0) {
                if (num % 10 == digit) {
                    count++;
                }
                num /= 10;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {12, 54, 32, 22};
        int digit = 2;

        System.out.println(countDigit(nums, digit)); // Output: 4
    }
}