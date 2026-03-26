import java.util.Scanner;

/*
Problem: Transition Point in Binary Array
Description:
Given a sorted array containing only 0s and 1s,
find the first index where 1 appears.

Approach: Binary Search
Time Complexity: O(log n)
Space Complexity: O(1)
*/

public class TransitionPointFinder {

    public static int findTransitionPoint(int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        int ans = -1;

        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (arr[mid] == 1) {
                ans = mid;
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];


        System.out.println("Enter elements (0s and 1s only):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findTransitionPoint(arr);


        if (result == -1) {
            System.out.println("No transition point (no 1 found)");
        } else {
            System.out.println("Transition point index: " + result);
        }

        sc.close();
    }
}