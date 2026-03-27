import java.util.Scanner;

/*
Problem: Single Number (LeetCode 136)

Description:
Given a non-empty array of integers, every element appears twice except for one.
Find that single one.

Approach: XOR
- a ^ a = 0
- a ^ 0 = a
- XOR all elements → duplicates cancel out → only unique remains

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class SingleNumberFinder {

    public static int findSingleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findSingleNumber(nums);

        // Output result
        System.out.println("Single number is: " + result);

        sc.close();
    }
}