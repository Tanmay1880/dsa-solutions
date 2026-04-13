import java.util.*;

/*
 * Problem: Find minimum distance between target index and start index
 *
 * Approach:
 * - Traverse the array once
 * - Whenever nums[i] == target:
 *      compute distance = abs(i - start)
 *      update minimum distance
 * - Return the minimum distance found
 *
 * Key Insight:
 * - No need for sorting or extra space
 * - Just track the minimum during traversal
 *
 * Time Complexity: O(n)
 * - Single pass through the array
 *
 * Space Complexity: O(1)
 * - No extra space used
 */

public class MinDistance {

    public static int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;
        int start = 3;

        System.out.println(getMinDistance(nums, target, start)); // Output: 1
    }
}