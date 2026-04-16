import java.util.HashSet;

/*
 * Problem: Happy Number
 *
 * A number is "happy" if repeatedly replacing it with the sum of the squares
 * of its digits eventually leads to 1.
 *
 * Approach:
 * - Use a HashSet to detect cycles
 * - Keep generating next number using sum of squares of digits
 * - If we reach 1 → return true
 * - If we see a number again → cycle → return false
 *
 * Time Complexity: O(log n) per iteration
 * Space Complexity: O(log n) for HashSet
 */

public class HappyNumber {

    public static boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {

            // If number repeats → cycle detected
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);

            // Generate next number
            n = getNext(n);
        }

        return true;
    }

    // Helper function: sum of squares of digits
    private static int getNext(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(2));  // false
    }
}