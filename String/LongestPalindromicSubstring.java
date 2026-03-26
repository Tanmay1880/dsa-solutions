import java.util.Scanner;

/*
Problem: Longest Palindromic Substring

Approach: Expand Around Center
- Consider each index as center
- Expand for both odd and even length palindromes

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expandAroundCenter(s, i, i);     // odd length
            int len2 = expandAroundCenter(s, i, i + 1); // even length

            int maxLen = Math.max(len1, len2);

            int currentLength = end - start + 1;

            if (maxLen > currentLength) {
                start = i - (maxLen - 1) / 2;
                end   = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        String result = longestPalindrome(input);

        System.out.println("Longest Palindromic Substring: " + result);

        sc.close();
    }
}