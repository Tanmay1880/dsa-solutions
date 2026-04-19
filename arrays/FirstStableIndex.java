import java.util.*;

/*
 * Problem: Find first stable index
 *
 * Definition:
 * - For index i:
 *      max value from left (0 → i)
 *      min value from right (i → n-1)
 * - If their difference ≤ k → index is stable
 *
 * Approach:
 * - Precompute:
 *      prefixMax[i] = max(0 → i)
 *      suffixMin[i] = min(i → n-1)
 * - Then check each index
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class FirstStableIndex {

    public static int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        // Step 1: prefix max
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        // Step 2: suffix min
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        // Step 3: check condition
        for (int i = 0; i < n; i++) {
            if (prefixMax[i] - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 5};
        int k = 2;

        System.out.println(firstStableIndex(nums, k));
    }
}