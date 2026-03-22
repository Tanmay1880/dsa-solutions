// Problem: Find maximum subarray sum (Kadane's Algorithm)
// Approach: Keep track of current sum and reset when it becomes negative
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

public class MaximumSubarray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = maxSubArray(arr);

        System.out.println("Maximum Subarray Sum: " + result);

        sc.close();
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = nums[0];

        for (int num : nums) {
            currentSum += num;

            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}