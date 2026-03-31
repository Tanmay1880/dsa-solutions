import java.util.Scanner;

/*
Problem: Minimum Distance Between Two Numbers

Description:
Find the minimum distance between occurrences of x and y in an array.

Approach:
- Traverse array once
- Track last seen index and value
- Update distance when switching between x and y

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class MinDistanceBetweenElements {

    public static int minDist(int[] arr, int x, int y) {

        if (x == y) return 0;

        int lastIndex = -1;
        int lastValue = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == x || arr[i] == y) {

                if (lastIndex != -1 && arr[i] != lastValue) {
                    minDistance = Math.min(minDistance, i - lastIndex);
                }

                lastIndex = i;
                lastValue = arr[i];
            }
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
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

        System.out.print("Enter x: ");
        int x = sc.nextInt();

        System.out.print("Enter y: ");
        int y = sc.nextInt();

        int result = minDist(arr, x, y);

        System.out.println("Minimum distance: " + result);

        sc.close();
    }
}