/**
 * Problem: Climbing Stairs
 *
 * You can climb either 1 or 2 steps at a time.
 * Find the number of distinct ways to reach the top.
 *
 * Approach:
 * This is a Dynamic Programming problem.
 * At step n, you can reach it from:
 *  - step (n-1) by taking 1 step
 *  - step (n-2) by taking 2 steps
 *
 * So, total ways:
 *   ways[n] = ways[n-1] + ways[n-2]
 *
 * Optimized to O(1) space using two variables.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ClimbingStairs {

    public static int countWays(int n) {
        if (n <= 2) return n;

        int waysToPrevPrev = 1; // f(1)
        int waysToPrev = 2;     // f(2)

        for (int i = 3; i <= n; i++) {
            int currentWays = waysToPrev + waysToPrevPrev;
            waysToPrevPrev = waysToPrev;
            waysToPrev = currentWays;
        }

        return waysToPrev;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways: " + countWays(n));
    }
}