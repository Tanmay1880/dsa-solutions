import java.util.Scanner;

/*
Problem: Find Minimum in Rotated Sorted Array (LeetCode 153)

Description:
Find the minimum element in a rotated sorted array.

Approach:
- Use binary search
- Compare mid with right to determine sorted half

Time Complexity: O(log n)
Space Complexity: O(1)
*/

public class FindMinimumRotatedArray {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Minimum is in left half (including mid)
            if (nums[mid] <= nums[right]) {
                right = mid;
            }
            // Minimum is in right half (excluding mid)
            else {
                left = mid + 1;
            }
        }

        return nums[left];
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

        int result = findMin(nums);

        System.out.println("Minimum element: " + result);

        sc.close();
    }
}