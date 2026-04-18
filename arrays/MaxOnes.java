import java.util.*;

/*
 * Problem: Maximize number of 1s by flipping one subarray
 *
 * Approach:
 * - Count total number of 1s initially
 * - Convert array:
 *      0 → +1 (gain)
 *      1 → -1 (loss)
 * - Apply Kadane’s algorithm to find max gain
 * - Result = original ones + max gain
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class MaxOnes {

    public static int maxOnes(int[] arr) {

        int originalOnes = 0;
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {

            // Count original ones
            if (arr[i] == 1) {
                originalOnes++;
            }

            // Transform value
            int val = (arr[i] == 0) ? 1 : -1;

            // Kadane’s Algorithm
            currentSum = Math.max(val, currentSum + val);
            maxSum = Math.max(maxSum, currentSum);
        }

        return originalOnes + maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0};

        System.out.println(maxOnes(arr)); // Output: 4
    }
}