/**
 * Problem: LeetCode 69 - Sqrt(x)
 *
 * Approach:
 * - Binary search on answer space [1, x]
 * - Find largest mid such that mid * mid <= x
 * - Use division to avoid overflow
 *
 * Time Complexity: O(log x)
 * Space Complexity: O(1)
 */
public class IntegerSquareRoot {

    public static int mySqrt(int x) {
        if (x < 2) return x;

        int low = 1, high = x / 2;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid <= x / mid) {
                ans = mid;       // valid candidate
                low = mid + 1;   // try larger
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8)); // Output: 2
    }
}