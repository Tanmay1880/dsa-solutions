/**
 * Problem: LeetCode 48 - Rotate Image
 *
 * Approach:
 * - Step 1: Transpose the matrix
 * - Step 2: Reverse each row
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int row = 0; row < n; row++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left++;
                right--;
            }
        }
    }
}