// Problem: Find first occurrence of a key in a sorted array
// Approach: Binary Search (modified)
// Time Complexity: O(log n)
// Space Complexity: O(1)

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter SORTED array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter key to search:");
        int key = sc.nextInt();

        int result = findFirstOccurrence(arr, key);

        System.out.println("Index: " + result);

        sc.close();
    }

    public static int findFirstOccurrence(int[] a, int key) {
        int first = 0;
        int last = a.length - 1;
        int ans = -1;

        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (a[mid] == key) {
                ans = mid;
                last = mid - 1;
            } else if (a[mid] < key) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        return ans;
    }
}