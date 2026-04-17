import java.util.*;

/*
 * Problem: Check if a string can be rearranged to form a palindrome
 *
 * Approach:
 * - Count frequency of each character
 * - For a palindrome:
 *      - At most ONE character can have odd frequency
 *      - All others must have even frequency
 *
 * Example:
 * "aab" → a=2, b=1 → valid (one odd)
 * "abc" → a=1, b=1, c=1 → invalid (three odd)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (since charset is limited)
 */

public class CanFormPalindrome {

    public static boolean canFormPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: count frequency
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: count odd frequencies
        int oddCount = 0;

        for (int freq : map.values()) {
            if (freq % 2 != 0) {
                oddCount++;

                // Optimization: early exit
                if (oddCount > 1) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFormPalindrome("aab")); // true
        System.out.println(canFormPalindrome("abc")); // false
        System.out.println(canFormPalindrome("racecar")); // true
    }
}