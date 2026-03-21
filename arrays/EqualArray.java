// Problem: Check if two arrays are equal (same elements and frequency)
// Approach: Use HashMap to count frequency
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.Scanner;

public class EqualArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first array size:");
        int n1 = sc.nextInt();
        int[] a = new int[n1];

        System.out.println("Enter elements:");
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Enter second array size:");
        int n2 = sc.nextInt();
        int[] b = new int[n2];

        System.out.println("Enter elements:");
        for (int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }

        boolean result = checkEqual(a, b);
        System.out.println("Are equal: " + result);

        sc.close();
    }

    public static boolean checkEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : b) {
            if (!map.containsKey(num) || map.get(num) == 0) {
                return false;
            }
            map.put(num, map.get(num) - 1);
        }

        return true;
    }
}