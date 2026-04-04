import java.util.*;

/**
 * Problem: LeetCode 1046 - Last Stone Weight
 *
 * Approach:
 * - Use Max Heap to always pick the two largest stones
 * - Smash them and insert remaining weight
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones)); // Output: 1
    }
}