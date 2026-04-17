import java.util.*;

/*
 * Problem: Running Sum of 1D Array
 *
 * Approach:
 * - Traverse the array
 * - Keep a cumulative sum
 * - Update each index with sum so far
 *
 * Example:
 * nums = [1,2,3,4]
 * → [1, 3, 6, 10]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (in-place)
 */

public class RunningSum {

    public static int[] runningSum(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = runningSum(nums);

        System.out.println(Arrays.toString(result)); // [1, 3, 6, 10]
    }
}