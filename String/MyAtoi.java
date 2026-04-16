import java.util.*;

/*
 * Problem: Implement atoi (String to Integer)
 *
 * Approach:
 * 1. Skip leading whitespaces
 * 2. Check for optional sign (+ / -)
 * 3. Convert digits one by one
 * 4. Handle overflow BEFORE adding digit
 * 5. Stop when non-digit character is found
 *
 * Key Insight:
 * - We build number digit by digit
 * - Before multiplying by 10, check if it will overflow
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class MyAtoi {

    public static int myAtoi(String s) {
        int i = 0, n = s.length();

        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // 3. Convert digits
        int result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. Check overflow BEFORE multiplication
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        // 5. Apply sign and return
        return sign == 1 ? result : -result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(myAtoi("42"));              // 42
        System.out.println(myAtoi("   -42"));          // -42
        System.out.println(myAtoi("4193 with words")); // 4193
        System.out.println(myAtoi("words 987"));       // 0
        System.out.println(myAtoi("-91283472332"));    // Integer.MIN_VALUE
    }
}