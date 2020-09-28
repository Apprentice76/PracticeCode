import java.util.*;

public class BubbleSort {
    static int[] bubsort(int[] arr) {
        int size = arr.length;
        for (int i=0; i<size-1; i++)
            for (int j=0; j<size-1-i; j++) 
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
        return arr;
    }
    // Driver code
    public static void main(String[] args) {
        int arr[] = {1 , 7, 8, 4, 2, 6, 9, 0, 3, 2};
        System.out.println(Arrays.toString(bubsort(arr)));
    }
}