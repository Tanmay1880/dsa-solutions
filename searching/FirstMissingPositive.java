import java.util.Scanner;

/*
Problem: First Missing Positive

Approach: Cyclic Sort / Index Placement
- Place each number at correct index (value-1)
- Then find first mismatch

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class FirstMissingPositive {

    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;


        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n &&
                    nums[nums[i] - 1] != nums[i]) {

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }


        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findFirstMissingPositive(nums);

        System.out.println("First missing positive: " + result);

        sc.close();
    }
}