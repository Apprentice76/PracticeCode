import java.util.Scanner;

public class RainwaterTrapped {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        // int[] arr = {0,4,0,0,0,0,3};
        RainwaterTrapped var = new RainwaterTrapped();
        int result = var.trapped(arr);
        System.out.println(result);
    }
                                                                    // 0 4 0 0 0 0 3
    int trapped(int[] arr) {                                        
        int water=0;
        if (arr.length <= 2) return 0;
        int j=arr.length - 2;
        int[] lMax = new int[arr.length];                           // 0 4 4 4 4 4 4
        int[] rMax = new int[arr.length];                           // 4 4 3 3 3 3 3
        lMax[0] = arr[0];
        rMax[arr.length-1] = arr[arr.length-1];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > lMax[i-1]) lMax[i] = arr[i];
            else lMax[i] = lMax[i-1];
            if (arr[j] < rMax[j+1]) rMax[j] = rMax[j+1];
            else rMax[j] = arr[j];
            j--;
        }
        // System.out.println(Arrays.toString(rMax));
        // System.out.println(Arrays.toString(lMax));
        for (int i=1; i<arr.length-1; i++) 
            if (lMax[i-1] > arr[i] && rMax[i+1] > arr[i]) water += Math.min(lMax[i-1], rMax[i+1]) - arr[i];

        return water;
    }

    // cleaner solution:
    
    // public class Solution {
    //     // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    //     public int trap(final int[] A) {
    //         int water = 0;
    //         int n = A.length;
    //         if (n <= 2) return 0;
    //         int[] lMax = new int[n];
    //         int[] rMax = new int[n];
    //         lMax[0] = A[0];
    //         rMax[n-1] = A[n-1];
    //         int j = n-2;
    //         for (int i=1; i<n; i++) {
    //             if (A[i] > lMax[i-1]) lMax[i] = A[i];
    //             else lMax[i] = lMax[i-1];
    //             if (A[j] > rMax[j+1]) rMax[j] = A[j];
    //             else rMax[j] = rMax[j+1];
    //             j--;
    //         }
    //         for (int i=1; i<n-1; i++) {
    //             int minh = Math.min(lMax[i-1], rMax[i+1]);
    //             if (minh > A[i]) water += minh - A[i];
    //         }
    //         return water;
    //     }
    // }
}