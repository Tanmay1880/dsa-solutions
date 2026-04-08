import java.util.*;

/**
 * Problem: Top K Frequent Elements (LeetCode 347)
 *
 * Approach:
 * 1. Count frequency using HashMap
 * 2. Use Bucket Sort where index = frequency
 * 3. Traverse buckets from high to low to collect top K elements
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket array (index = frequency)
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets.get(freq).add(num);
        }

        // Step 3: Collect top K elements
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.size() - 1; i >= 0 && index < k; i--) {
            for (int num : buckets.get(i)) {
                result[index++] = num;
                if (index == k) break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}