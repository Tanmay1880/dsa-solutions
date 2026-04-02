/**
 * Problem: LeetCode 852 - Peak Index in a Mountain Array
 *
 * A mountain array:
 * - strictly increasing
 * - then strictly decreasing
 *
 * Approach:
 * - Use binary search on slope
 * - If increasing → move right
 * - If decreasing → move left
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class PeakIndexMountainArray {

    public static int findPeakIndex(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1; // peak on right
            } else {
                high = mid; // peak on left or mid
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 5, 3, 1};
        System.out.println(findPeakIndex(arr)); // Output: 2
    }
}