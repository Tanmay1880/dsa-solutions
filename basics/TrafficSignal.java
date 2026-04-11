/*
 * Problem: Traffic Signal State based on timer
 *
 * Approach:
 * - Direct conditional checks based on given ranges
 * - Return corresponding signal color
 *
 * Rules:
 * - 0          → Green
 * - 30         → Orange
 * - 31 to 90   → Red
 * - Otherwise  → Invalid
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class TrafficSignal {

    public static String trafficSignal(int timer) {

        if (timer == 0) {
            return "Green";
        }
        else if (timer == 30) {
            return "Orange";
        }
        else if (timer > 30 && timer <= 90) {
            return "Red";
        }

        return "Invalid";
    }

    public static void main(String[] args) {
        System.out.println(trafficSignal(0));   // Green
        System.out.println(trafficSignal(30));  // Orange
        System.out.println(trafficSignal(50));  // Red
        System.out.println(trafficSignal(10));  // Invalid (based on current rules)
    }
}