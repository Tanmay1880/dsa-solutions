/**
 * Problem: LeetCode 162 - Find Peak Element
 *
 * A peak element is greater than its neighbors.
 * We use binary search to find one peak.
 *
 * Approach:
 * - Compare nums[mid] with nums[mid + 1]
 * - If increasing → peak lies right
 * - If decreasing → peak lies left (including mid)
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindPeakElement {

    public static int findPeak(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1; // move right
            } else {
                high = mid; // move left
            }
        }

        return low; // peak index
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeak(nums)); // Output: 2
    }
}