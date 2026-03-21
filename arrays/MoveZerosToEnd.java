// Problem: Move all zeros to end while maintaining order
// Approach: Shift non-zero elements forward using insert pointer
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Scanner;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        pushZerosToEnd(arr);
        printArray(arr);

        sc.close();
    }

    static void pushZerosToEnd(int[] arr) {
        int insertPos = 0;

        for (int num : arr) {
            if (num != 0) {
                arr[insertPos++] = num;
            }
        }

        while (insertPos < arr.length) {
            arr[insertPos++] = 0;
        }
    }

    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}