/*
 * Optimized Approach (O(1) space)
 *
 * Use first row and column as markers
 *
 * Time: O(m*n)
 * Space: O(1)
 */

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean col0 = false;

        // Step 1: mark rows & cols
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = true;

            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row
                    matrix[0][j] = 0; // mark col
                }
            }
        }

        // Step 2: update matrix (reverse to avoid overwrite)
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (col0) {
                matrix[i][0] = 0;
            }
        }
    }
}