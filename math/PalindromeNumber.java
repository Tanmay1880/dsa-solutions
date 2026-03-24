// Problem: Check if a number is palindrome
// Approach: Reverse only half of the number
// Time Complexity: O(log n)
// Space Complexity: O(1)

import java.util.*;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        // Edge cases
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x = x / 10;
        }

        return (x == reversedHalf) || (x == reversedHalf / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int n = sc.nextInt();

        boolean result = isPalindrome(n);

        System.out.println("Is Palindrome: " + result);

        sc.close();
    }
}