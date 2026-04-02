/**
 * Problem: LeetCode 875 - Koko Eating Bananas
 *
 * Approach:
 * - Binary Search on Answer (eating speed k)
 * - Check if Koko can finish within h hours
 *
 * Time Complexity: O(n log max(pile))
 * Space Complexity: O(1)
 */
public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canFinishWithinHours(piles, h, mid)) {
                high = mid; // try smaller speed
            } else {
                low = mid + 1; // increase speed
            }
        }

        return low;
    }

    private static boolean canFinishWithinHours(int[] piles, int h, int k) {
        long totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile + k - 1) / k;

            if (totalHours > h) return false; // early exit
        }

        return true;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h)); // Output: 4
    }
}