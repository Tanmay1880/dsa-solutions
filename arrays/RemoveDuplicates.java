// Problem: Remove duplicates from a sorted array
// Approach: Traverse and add only unique elements
// Time Complexity: O(n)
// Space Complexity: O(1) (excluding output list)

import java.util.*;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter SORTED array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> result = removeDuplicates(arr);

        System.out.println("Result:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        if (arr.length == 0) return result;

        result.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }

        return result;
    }
}