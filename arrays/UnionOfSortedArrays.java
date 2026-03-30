import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Problem: Union of Two Sorted Arrays

Description:
Return the union of two sorted arrays without duplicates.

Approach:
- Use two pointers to merge arrays
- Avoid duplicates by checking last inserted element

Time Complexity: O(n + m)
Space Complexity: O(1) (excluding result)
*/

public class UnionOfSortedArrays {

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                addIfUnique(result, a[i]);
                i++;
            } else if (a[i] > b[j]) {
                addIfUnique(result, b[j]);
                j++;
            } else {
                addIfUnique(result, a[i]);
                i++;
                j++;
            }
        }

        while (i < a.length) {
            addIfUnique(result, a[i]);
            i++;
        }

        while (j < b.length) {
            addIfUnique(result, b[j]);
            j++;
        }

        return result;
    }

    private static void addIfUnique(ArrayList<Integer> list, int value) {
        if (list.isEmpty() || list.get(list.size() - 1) != value) {
            list.add(value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();
        int[] b = new int[m];

        System.out.println("Enter elements of second array:");
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);

        ArrayList<Integer> union = findUnion(a, b);

        System.out.println("Union: " + union);

        sc.close();
    }
}