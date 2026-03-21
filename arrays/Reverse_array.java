// Problem: Reverse an array
// Approach: Two-pointer swap
// Time Complexity: O(n)
import java.util.Scanner;

public class Reverse_array {

    public static void main(String[] args) {
         System.out.println("enter array size ");
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt() ;
        int arr [] = new int[r];
        System.out.println("enter array element");
        for (int i=0 ; i<r;i++) {
            arr[i]=sc.nextInt();
        }
        reverseArray(arr);
        sc.close();
    }

    public static void reverseArray(int arr[]) {

        int first =0;
        int last = arr.length-1;


        while (last>first) {
            int temp = arr[first];
            arr[first]=arr[last];
            arr[last]=temp;
            first++;
            last--;



        }

         for (int i : arr) {
        System.out.print(i + " ");
    }


    }
}