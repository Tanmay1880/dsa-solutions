import java.util.*;

/**
 * Problem:
 * Calculate mirror frequency difference:
 * - a ↔ z, b ↔ y, ..., 0 ↔ 9
 * - Sum absolute difference of frequencies
 *
 * Time: O(n)
 * Space: O(1)
 */
public class MirrorFrequency {

    public static int mirrorFrequency(String s) {

        int[] freq = new int[128]; // ASCII

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        int totalDifference = 0;

        // Process only one side to avoid double counting
        for (char ch = 0; ch < 128; ch++) {

            char mirror;

            if (ch >= 'a' && ch <= 'z') {
                mirror = (char) ('z' - (ch - 'a'));
            }
            else if (ch >= '0' && ch <= '9') {
                mirror = (char) ('9' - (ch - '0'));
            }
            else {
                continue; // ignore unsupported chars
            }

            if (ch <= mirror) {
                totalDifference += Math.abs(freq[ch] - freq[mirror]);
            }
        }

        return totalDifference;
    }

    public static void main(String[] args) {
        System.out.println(mirrorFrequency("abz09"));
    }
}