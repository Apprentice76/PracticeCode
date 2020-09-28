import java.util.Arrays;

public class CountingSort {
    static void countsort(int[] arr, int size) {
        int[] tmp = new int[size];
        int max = arr[0];
        for (int a: arr) max = (max > a) ? max : a;
        int[] count = new int[max+1];
        Arrays.fill(count, 0);
        for (int i=0; i<size; i++) {
            count[arr[i]]+=1;
        }
        // System.out.println(Arrays.toString(count));
        for (int i=1; i<count.length; i++) count[i] += count[i-1];
        // System.out.println(Arrays.toString(count));
        for (int i=size-1; i>=0; i--) {
            tmp[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }
        // System.out.println(Arrays.toString(tmp));
        for (int i=0; i<size; i++) arr[i] = tmp[i];
    }
    
    // Driver code
    public static void main(String[] args) {
        int[] arr = {0, 7, 8, 4, 2, 5, 100, 7, 8, 4, 2, 9, 6, 5, 1, 6, 10, 11};
        countsort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}