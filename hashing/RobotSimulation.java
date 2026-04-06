import java.util.*;

/**
 * Problem: LeetCode 874 - Walking Robot Simulation
 *
 * Approach:
 * - Simulate robot movement step by step
 * - Use HashSet for obstacle lookup
 * - Track max distance from origin
 *
 * Time Complexity: O(total steps)
 * Space Complexity: O(n)
 */
public class RobotSimulation {

    public static int robotSim(int[] commands, int[][] obstacles) {

        Set<Long> obstacleSet = new HashSet<>();

        for (int[] obs : obstacles) {
            long key = (((long) obs[0]) << 32) | (obs[1] & 0xffffffffL);
            obstacleSet.add(key);
        }

        int x = 0, y = 0;
        int directionIndex = 0;

        int[][] directions = {
                {0, 1},   // North
                {1, 0},   // East
                {0, -1},  // South
                {-1, 0}   // West
        };

        int maxDistance = 0;

        for (int command : commands) {

            if (command == -1) {
                directionIndex = (directionIndex + 1) % 4;
            }
            else if (command == -2) {
                directionIndex = (directionIndex + 3) % 4;
            }
            else {
                for (int step = 0; step < command; step++) {

                    int nextX = x + directions[directionIndex][0];
                    int nextY = y + directions[directionIndex][1];

                    long key = (((long) nextX) << 32) | (nextY & 0xffffffffL);

                    if (obstacleSet.contains(key)) break;

                    x = nextX;
                    y = nextY;

                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }

        return maxDistance;
    }
}