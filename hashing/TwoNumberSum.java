// Problem: Check if any two numbers sum to target
// Approach: Use HashMap to store visited elements
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.Scanner;

public class TwoNumberSum {

    public static void main(String[] args) {
        System.out.println("enter array size ");
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt() ;
        int arr [] = new int[r];
        System.out.println("enter array element");
        for (int i=0 ; i<r;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println("enter target to be found");
        int target= sc.nextInt();

      boolean result =  twoSum(arr, target);

      System.out.println(result);

        sc.close();
    }

   static boolean twoSum(int arr[], int target){

    HashMap<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i < arr.length; i++){

        int needed = target - arr[i];

        if(map.containsKey(needed)){
            return true;
        }

        map.put(arr[i], i);
    }

    return false;
}

}