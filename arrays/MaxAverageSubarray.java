import java.util.Scanner;

/*
Problem: Maximum Average Subarray I

Description:
Find the maximum average of a subarray of size k.

Approach: Sliding Window (Fixed Size)
- Compute first window sum
- Slide window by adding next element and removing previous

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class MaxAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            throw new IllegalArgumentException("Invalid input");
        }

        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        long maxSum = sum;
 
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
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

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        double result = findMaxAverage(nums, k);

        System.out.println("Maximum average: " + result);

        sc.close();
    }
}