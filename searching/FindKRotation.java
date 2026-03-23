// Problem: Find number of rotations in a sorted rotated array
// Approach: Binary search to find index of minimum element
// Time Complexity: O(log n)
// Space Complexity: O(1)

import java.util.*;

public class FindKRotation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements of rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findKRotation(arr);

        System.out.println("Number of rotations: " + result);

        sc.close();
    }

    public static int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}