import java.util.*;

/**
 * Problem:
 * Find all numbers ≤ n that can be expressed as sum of two cubes
 * in at least two different ways.
 *
 * Example: 1729 = 1³ + 12³ = 9³ + 10³
 *
 * Time Complexity: O(n^(2/3))
 * Space Complexity: O(n^(2/3))
 */
public class TaxicabNumbers {

    public static List<Integer> findGoodIntegers(int n) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> sumFrequency = new HashMap<>();

        int limit = (int) Math.cbrt(n);

        for (int a = 1; a <= limit; a++) {
            int cubeA = a * a * a;

            for (int b = a; b <= limit; b++) {
                int sum = cubeA + b * b * b;

                if (sum > n) break;

                sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : sumFrequency.entrySet()) {
            if (entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findGoodIntegers(2000)); // Example: [1729]
    }
}