/**
 * Problem: LeetCode 28 - Find First Occurrence in a String
 *
 * Approach:
 * - Naive substring matching
 * - Check every possible starting index
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */
public class FirstOccurrenceInString {

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad")); // Output: 0
    }
}