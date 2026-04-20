import java.util.*;

/*
 * Problem: Maximum distance between two houses with different colors
 *
 * Approach:
 * - Check farthest house from the first house with different color
 * - Check farthest house from the last house with different color
 * - Take maximum of both
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class MaxDistanceColors {

    public static int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        // Case 1: compare with first house
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                maxDist = i;
                break;
            }
        }

        // Case 2: compare with last house
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, n - 1 - i);
                break;
            }
        }

        return maxDist;
    }

    public static void main(String[] args) {
        int[] colors = {1, 1, 1, 6, 1, 1, 1};

        System.out.println(maxDistance(colors)); // Output: 3
    }
}