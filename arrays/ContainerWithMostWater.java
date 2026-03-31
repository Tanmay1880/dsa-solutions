import java.util.Scanner;

/*
Problem: Container With Most Water (LeetCode 11)

Description:
Find two lines that together with x-axis form a container that holds the most water.

Approach: Two Pointers
- Start with widest container
- Move pointer with smaller height inward

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            throw new IllegalArgumentException("At least two heights required");
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int currentArea = minHeight * width;

            maxArea = Math.max(maxArea, currentArea);

            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
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

        int result = maxArea(height);

        System.out.println("Maximum water area: " + result);

        sc.close();
    }
}