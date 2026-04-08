/**
 * Problem: House Robber (LeetCode 198)
 *
 * You are given an array where each element represents money in a house.
 * You cannot rob adjacent houses.
 *
 * Approach:
 * At each house, we decide:
 *  - Skip it → keep previous max
 *  - Rob it → add current value to max till i-2
 *
 * Recurrence:
 *   dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 *
 * Optimized to O(1) space.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class HouseRobber {

    public static int maxRobAmount(int[] nums) {
        int maxTillPrev = 0;      // dp[i-1]
        int maxTillPrevPrev = 0;  // dp[i-2]

        for (int money : nums) {
            int currentMax = Math.max(maxTillPrev, maxTillPrevPrev + money);
            maxTillPrevPrev = maxTillPrev;
            maxTillPrev = currentMax;
        }

        return maxTillPrev;
    }

    public static void main(String[] args) {
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println("Max loot: " + maxRobAmount(houses));
    }
}