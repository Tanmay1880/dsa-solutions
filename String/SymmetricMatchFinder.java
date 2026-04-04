/**
 * Problem:
 * Return the first index i such that s[i] == s[n - i - 1]
 *
 * Approach:
 * - Use two-pointer symmetry
 * - Only traverse till midpoint
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SymmetricMatchFinder {

    public static int firstSymmetricMatchIndex(String s) {
        if (s == null || s.length() == 0) return -1;

        int n = s.length();

        for (int i = 0; i <= n / 2; i++) {
            if (s.charAt(i) == s.charAt(n - i - 1)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstSymmetricMatchIndex("abca")); // Output: 1
    }
}