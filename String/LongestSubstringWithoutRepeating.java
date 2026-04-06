import java.util.*;

/**
 * Problem: LeetCode 3 - Longest Substring Without Repeating Characters
 *
 * Approach:
 * - Sliding window with hashmap storing last seen indices
 * - Maintain window with unique characters
 *
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset))
 */
public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

            char currentChar = s.charAt(windowEnd);

            if (lastSeenIndex.containsKey(currentChar)) {
                windowStart = Math.max(windowStart, lastSeenIndex.get(currentChar) + 1);
            }

            lastSeenIndex.put(currentChar, windowEnd);

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
    }
}