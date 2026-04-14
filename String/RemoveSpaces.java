import java.util.*;

/*
 * Problem: Remove all spaces from a string
 *
 * Approach:
 * - Traverse the string character by character
 * - Append only non-space characters to StringBuilder
 * - Convert StringBuilder to String and return
 *
 * Time Complexity: O(n)
 * - Traverse entire string once
 *
 * Space Complexity: O(n)
 * - New string created without spaces
 */

public class RemoveSpaces {

    public static String removeSpaces(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "Hello World From Java";
        System.out.println(removeSpaces(s)); // HelloWorldFromJava
    }
}