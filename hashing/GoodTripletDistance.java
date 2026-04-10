import java.util.*;

/*
 * Problem: Minimum distance of good triplet (same values)
 *
 * Approach:
 * - Group indices of same values using HashMap
 * - For each value, consider every 3 consecutive indices
 * - Use formula: distance = 2 * (k - i)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class GoodTripletDistance {

    public static int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: store indices
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDist = Integer.MAX_VALUE;

        // Step 2: process each value
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;

            // sliding window of size 3
            for (int i = 0; i <= list.size() - 3; i++) {
                int first = list.get(i);
                int third = list.get(i + 2);

                int dist = 2 * (third - first);
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,1,1,3};
        System.out.println(minimumDistance(nums1)); // 6

        int[] nums2 = {1,1,2,3,2,1,2};
        System.out.println(minimumDistance(nums2)); // 8

        int[] nums3 = {1};
        System.out.println(minimumDistance(nums3)); // -1
    }
}