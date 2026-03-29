import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem: Pascal's Triangle (LeetCode 118)

Description:
Generate first numRows of Pascal's Triangle.

Approach:
- Each row starts and ends with 1
- Middle elements = sum of two elements from previous row

Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

public class PascalsTriangleGenerator {

    public static List<List<Integer>> generateTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> prevRow = result.get(i - 1);
                    int value = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(value);
                }
            }

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        List<List<Integer>> triangle = generateTriangle(n);

        System.out.println("Pascal's Triangle:");
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }

        sc.close();
    }
}