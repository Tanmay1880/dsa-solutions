/**
 * Problem: Search in Rotated Sorted Array II (with duplicates)
 *
 * Approach:
 * Modified Binary Search.
 * - At least one half is sorted (unless duplicates cause ambiguity).
 * - If duplicates block decision, shrink boundaries.
 *
 * Time Complexity:
 * - Average: O(log n)
 * - Worst Case (duplicates): O(n)
 *
 * Space Complexity:
 * - O(1)
 */
public class RotatedArraySearchWithDuplicates {

    public static boolean search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return false;

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return true;

            // Case 1: Cannot determine sorted half due to duplicates
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
            }

            // Case 2: Left half is sorted
            else if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Case 3: Right half is sorted
            else {
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;

        System.out.println(search(arr, target)); // true
    }
}