import java.util.Arrays;

/*
 * Problem: Remove Duplicates from Sorted Array II
 *
 * Approach:
 * - Since the array is sorted, duplicates are adjacent.
 * - We allow each element to appear at most twice.
 * - Maintain a pointer `k` which represents the position to place the next valid element.
 * - Start iterating from index 2:
 *      - Compare current element nums[i] with nums[k - 2]
 *      - If they are different → it means current element can be placed
 *      - Otherwise → skip it (more than 2 duplicates)
 *
 * Key Insight:
 * - nums[k - 2] ensures we only allow at most 2 occurrences.
 *
 * Time Complexity: O(n)
 * - Single pass through the array
 *
 * Space Complexity: O(1)
 * - In-place modification, no extra space used
 */

public class RemoveDuplicatesII {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};

        System.out.println("Before: " + Arrays.toString(nums));

        int k = removeDuplicates(nums);

        System.out.println("After:  " + Arrays.toString(Arrays.copyOf(nums, k)));
        System.out.println("k = " + k);
    }
}