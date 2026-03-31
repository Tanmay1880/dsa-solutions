import java.util.Arrays;
import java.util.Scanner;

/*
Problem: 3Sum Closest (LeetCode 16)

Description:
Find three integers such that the sum is closest to target.

Approach:
- Sort array
- Fix one element
- Use two pointers for remaining pair
- Track closest sum

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Array must have at least 3 elements");
        }

        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            // Optional optimization: skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                int currentDiff = Math.abs(sum - target);
                int bestDiff = Math.abs(closestSum - target);

                if (currentDiff < bestDiff) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                }
                else if (sum > target) {
                    right--;
                }
                else {
                    return sum; // exact match
                }
            }
        }

        return closestSum;
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

        int result = threeSumClosest(nums, target);

        System.out.println("Closest sum: " + result);

        sc.close();
    }
}