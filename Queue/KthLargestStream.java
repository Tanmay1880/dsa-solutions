import java.util.*;

/**
 * Problem: LeetCode 703 - Kth Largest Element in a Stream
 *
 * Approach:
 * - Maintain a min heap of size k
 * - Heap contains k largest elements seen so far
 * - Root represents kth largest
 *
 * Time Complexity:
 * - add(): O(log k)
 * - constructor: O(n log k)
 *
 * Space Complexity: O(k)
 */
public class KthLargestStream {

    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargestStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestStream obj = new KthLargestStream(3, new int[]{4,5,8,2});
        System.out.println(obj.add(3));  // 4
        System.out.println(obj.add(5));  // 5
        System.out.println(obj.add(10)); // 5
        System.out.println(obj.add(9));  // 8
        System.out.println(obj.add(4));  // 8
    }
}