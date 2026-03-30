import java.util.Scanner;
import java.util.Arrays;

/*
Problem: Two Sum II - Input Array Is Sorted

Description:
Given a sorted array, find two numbers such that they add up to target.
Return 1-based indices.

Approach: Two Pointers
- Use left and right pointers
- Move pointers based on comparison with target

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class TwoSumSorted {

    public static int[] findTwoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-based index
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        throw new IllegalArgumentException("No valid pair found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter elements (sorted):");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] result = findTwoSum(numbers, target);

        System.out.println("Indices (1-based): " + Arrays.toString(result));

        sc.close();
    }
}