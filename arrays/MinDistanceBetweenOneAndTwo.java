/**
 * Problem:
 * Find minimum distance between occurrences of 1 and 2 in array
 *
 * Approach:
 * - Track last seen indices of 1 and 2
 * - Update min difference whenever both are seen
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinDistanceBetweenOneAndTwo {

    public static int minAbsoluteDifference(int[] nums) {
        int minDiff = Integer.MAX_VALUE;

        int lastIndexOfOne = -1;
        int lastIndexOfTwo = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                lastIndexOfOne = i;

                if (lastIndexOfTwo != -1) {
                    minDiff = Math.min(minDiff, i - lastIndexOfTwo);
                }
            }

            else if (nums[i] == 2) {
                lastIndexOfTwo = i;

                if (lastIndexOfOne != -1) {
                    minDiff = Math.min(minDiff, i - lastIndexOfOne);
                }
            }
        }

        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 1, 2};
        System.out.println(minAbsoluteDifference(nums)); // Output: 1
    }
}