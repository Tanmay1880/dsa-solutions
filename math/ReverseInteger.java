import java.util.Scanner;

/*
Problem: Reverse Integer (LeetCode 7)

Description:
Reverse digits of a 32-bit signed integer.
Return 0 if the reversed integer overflows.

Approach:
- Extract digits using modulo
- Build reversed number
- Check overflow before multiplying

Time Complexity: O(log10(n))
Space Complexity: O(1)
*/

public class ReverseInteger {

    public static int reverseNumber(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            // Check for overflow before multiplication
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 ||
                    (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            result = result * 10 + digit;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int x = sc.nextInt();

        int reversed = reverseNumber(x);

        System.out.println("Reversed integer: " + reversed);

        sc.close();
    }
}