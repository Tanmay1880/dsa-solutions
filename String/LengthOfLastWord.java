/**
 * Problem: LeetCode 58 - Length of Last Word
 *
 * Approach:
 * - Traverse string from end
 * - Skip trailing spaces
 * - Count characters until next space
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LengthOfLastWord {

    public static int getLastWordLength(String s) {
        if (s == null || s.length() == 0) return 0;

        int index = s.length() - 1;
        int length = 0;

        // Skip trailing spaces
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        // Count last word
        while (index >= 0 && s.charAt(index) != ' ') {
            length++;
            index--;
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "Hello World   ";
        System.out.println(getLastWordLength(s)); // Output: 5
    }
}