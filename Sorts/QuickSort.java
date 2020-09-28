// import java.util.*;

public class QuickSort {
    static int partition(int arr[], int low, int high) {
        randomPivot(arr, low, high);
        int tmp, piv=low;
        int i=low+1;
        for (int j=low+1; j<=high; j++)
            if (arr[j] < arr[piv]) {
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        i--;
        tmp = arr[i];
        arr[i] = arr[piv];
        arr[piv] = tmp;
        // System.out.println(Arrays.toString(arr));
        return i;
    }

    static void randomPivot(int[] arr, int low, int high) {
        Random rn = new Random();
        int piv_r = rn.nextInt(high - low + 1) + low;
        int tmp = arr[piv_r];
        arr[piv_r] = arr[low];
        arr[low] = tmp;
    }

    static void qcksort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            qcksort(arr, low, pi-1);
            qcksort(arr, pi+1, high);
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {100, 7, 8, 4, 2, 9, 6, 5, 1, 6, 10, 11};
        // int[] helper = new int [arr.length];
        qcksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}