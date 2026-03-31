import java.util.Scanner;

/*
Problem: Trapping Rain Water (LeetCode 42)

Description:
Given an array representing elevation map,
compute how much water it can trap.

Approach: Two Pointers
- Maintain leftMax and rightMax
- Move pointer with smaller height

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] height = new int[n];

        System.out.println("Enter heights:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int result = trap(height);

        System.out.println("Trapped water: " + result);

        sc.close();
    }
}