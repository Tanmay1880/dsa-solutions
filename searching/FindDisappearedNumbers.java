import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem: Find All Numbers Disappeared in an Array

Approach: Cyclic Sort (Index Placement)
- Place each number at index (value - 1)
- After placement, missing numbers are indices where nums[i] != i+1

Time Complexity: O(n)
Space Complexity: O(1) (excluding output list)
*/

public class FindDisappearedNumbers {

    public static List<Integer> findMissingNumbers(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n) {
                int correctIndex = nums[i] - 1;

                if (nums[i] == nums[correctIndex]) {
                    break;
                }


                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }


        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements (1 to n):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> missing = findMissingNumbers(nums);

        System.out.println("Missing numbers: " + missing);

        sc.close();
    }
}