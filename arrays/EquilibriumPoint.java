// Problem: Find equilibrium index where left sum = right sum
// Approach: Use total sum and prefix sum (leftSum)
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Scanner;

public class EquilibriumPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findEquilibrium(arr);
        System.out.println("Equilibrium Index: " + result);

        sc.close();
    }

    public static int findEquilibrium(int[] arr) {
        if (arr.length == 0) return -1;

        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];

            if (leftSum == totalSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }
}