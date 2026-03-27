import java.util.ArrayList;
import java.util.Scanner;

/*
Problem: Value Equal to Index Value

Description:
Find all elements in the array such that arr[i] == i + 1.

Approach:
- Traverse array
- Compare each value with (index + 1)

Time Complexity: O(n)
Space Complexity: O(k) (k = number of matching elements)
*/

public class ValueEqualToIndex {

    public static ArrayList<Integer> findValuesEqualToIndex(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            return result;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) {
                result.add(arr[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> result = findValuesEqualToIndex(arr);

        System.out.println("Values equal to index:");
        System.out.println(result);

        sc.close();
    }
}