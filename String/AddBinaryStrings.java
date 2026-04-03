/**
 * Problem: LeetCode 67 - Add Binary
 *
 * Approach:
 * - Traverse both strings from right to left
 * - Add digits along with carry
 * - Build result in reverse and then reverse it
 *
 * Time Complexity: O(max(n, m))
 * Space Complexity: O(max(n, m))
 */
public class AddBinaryStrings {

    public static String addBinary(String a, String b) {
        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (pointerA >= 0 || pointerB >= 0 || carry != 0) {

            int sum = carry;

            if (pointerA >= 0) {
                sum += a.charAt(pointerA--) - '0';
            }

            if (pointerB >= 0) {
                sum += b.charAt(pointerB--) - '0';
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011")); // Output: 10101
    }
}