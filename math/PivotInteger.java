// Problem: Find pivot integer such that
// sum(1 to x) = sum(x to n)
// Approach: Use mathematical formula
// Time Complexity: O(1)
// Space Complexity: O(1)

import java.util.*;

public class PivotInteger {

    public static int pivotInteger(int n) {

        int totalSum = n * (n + 1) / 2;

        int x = (int) Math.sqrt(totalSum);

        if (x * x == totalSum) {
            return x;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value of n:");
        int n = sc.nextInt();

        int result = pivotInteger(n);

        System.out.println("Pivot Integer: " + result);

        sc.close();
    }
}