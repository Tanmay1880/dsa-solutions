// Problem: Merge two sorted arrays into nums1 (in-place)
// nums1 has enough space to hold elements of nums2
// Approach: Start from end and fill largest elements first
// Time Complexity: O(m + n)
// Space Complexity: O(1)

import java.util.*;

public class MergeSortedArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of first array (m):");
        int m = sc.nextInt();

        System.out.println("Enter size of second array (n):");
        int n = sc.nextInt();

        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];

        System.out.println("Enter elements of first array (sorted):");
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of second array (sorted):");
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        merge(nums1, m, nums2, n);

        System.out.println("Merged Array:");
        for (int num : nums1) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // copy remaining elements of nums2
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}