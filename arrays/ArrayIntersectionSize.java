import java.util.HashSet;
import java.util.Scanner;

/*
Problem: Intersection Size of Two Arrays

Description:
Find the count of distinct common elements between two arrays.

Approach:
- Store elements of first array in HashSet
- Traverse second array and count only unique matches

Time Complexity: O(n + m)
Space Complexity: O(n)
*/

public class ArrayIntersectionSize {

    public static int findIntersectionSize(int[] a, int[] b) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> counted = new HashSet<>();

        int count = 0;

        for (int num : a) {
            setA.add(num);
        }

        for (int num : b) {
            if (setA.contains(num) && !counted.contains(num)) {
                count++;
                counted.add(num);
            }
        }

        return count;
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

        int result = findIntersectionSize(a, b);

        System.out.println("Intersection size (distinct elements): " + result);

        sc.close();
    }
}