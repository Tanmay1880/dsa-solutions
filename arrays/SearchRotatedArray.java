import java.util.Scanner;

/*
Problem: Search in Rotated Sorted Array (LeetCode 33)

Description:
Search target in a rotated sorted array.

Approach:
- Use modified binary search
- At each step, determine which half is sorted
- Check if target lies in sorted half

Time Complexity: O(log n)
Space Complexity: O(1)
*/

public class SearchRotatedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int result = search(nums, target);

        System.out.println("Target index: " + result);

        sc.close();
    }
}