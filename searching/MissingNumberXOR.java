import java.util.Scanner;

/*
Problem: Missing Number (LeetCode 268)

Description:
Given an array containing n distinct numbers in the range [0, n],
find the only number missing from the array.

Approach: XOR
- XOR all indices and elements
- Duplicate values cancel out
- Remaining value is the missing number

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class MissingNumberXOR {

    public static int findMissingNumber(int[] nums) {
        int xor = nums.length;

        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
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
        System.out.println("Enter elements (range 0 to n):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int missing = findMissingNumber(nums);

        // Output
        System.out.println("Missing number is: " + missing);

        sc.close();
    }
}