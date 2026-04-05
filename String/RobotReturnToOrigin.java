/**
 * Problem: LeetCode 657 - Robot Return to Origin
 *
 * Approach:
 * - Simulate movement using coordinates
 * - Check if final position is origin
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RobotReturnToOrigin {

    public static boolean judgeCircle(String moves) {
        int horizontal = 0, vertical = 0;

        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U': vertical++; break;
                case 'D': vertical--; break;
                case 'R': horizontal++; break;
                case 'L': horizontal--; break;
                default:
                    throw new IllegalArgumentException("Invalid move: " + move);
            }
        }

        return horizontal == 0 && vertical == 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UDLR")); // true
    }
}