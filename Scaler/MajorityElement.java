// import java.util.*;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        // int[] arr = new int[n];
        // for (int i=0; i<n; i++) {
        //     arr[i] = scan.nextInt();
        // }
        scan.close();
        int[] arr = {0,4,0,0,0,0,3};
        MajorityElement var = new MajorityElement();
        int result = var.majElement(arr);
        System.out.println(result);
    }

    // Ideal one-pass solution: Dynamic Programming (Boyer Moore Voting Algo)

    // public int majorityElement(final int[] A) {
    //     int n = A.length;
    //     int count = 0;
    //     int me = A[0];
    //     for (int i=0; i<n; i++) {
    //         if (A[i] == me) count++;
    //         else if (A[i] != me && count > 0) count--;
    //         else if (count == 0) me = A[i];
    //     }
    //     return me;
    // }


    int majElement(int[] A) {
        int n = A.length;
        // int maj = n/2+1;
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i=0; i<n; i++) {
        //     map.put(A[i], map.getOrDefault(A[i], 0)+1);
        //     // System.out.println(map.get(A[i]));
        //     if (map.get(A[i]) == maj) return A[i];
        // }

        // My Solution 2: replaces non required ints with a number not in array, Integer.MIN_VALUE, will fail if array has that element!
        int j = n-1;
        for (int i=0; i<=j; i++) {
            if (A[i] != A[j]) {
                A[i] = Integer.MIN_VALUE;
                A[j--] = Integer.MIN_VALUE;
            }
        }

        for (int i=0; i<n; i++) {
            if (A[i] != Integer.MIN_VALUE) return A[i];
        }

        

        // Brute-force: O(n^2) or Sort the Array and Check mid element: O(nlgn)
        // for (int i=0; i<n; i++) {
        //     int e = 0;
        //     for (int j=0; j<n; j++) {
        //         if (A[i] == A[j]) e++;
        //         if (e == maj) return A[i];
        //     }
        // }


        return -1;
    }
}