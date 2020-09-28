import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    static void recursiveSort(int[] arr, int l, int r, int[] helper) {
        if (l < r) {
            int mid = l + (r-l)/2;
            recursiveSort(arr, l, mid, helper);
            recursiveSort(arr, mid+1, r, helper);
            merge(arr, l, mid, r, helper);
        }
    }

    // right-inclusive
    private static void merge(int[] arr, int l, int mid, int r, int[] helper) {
        int i = l;
        int j = mid+1;
        int k = l;

        while (i <= mid || j <= r) {
            if (i <= mid && j <= r) {
                if (arr[i] <= arr[j])
                    helper[k++] = arr[i++];
                else
                    helper[k++] = arr[j++];
            } else if (j > r)
                helper[k++] = arr[i++];
            else
                helper[k++] = arr[j++];
        }

        for (i = l; i < r + 1; i++)
            arr[i] = helper[i];
    }

    public static void iterativeSort(int[] arr, int[] helper) {
        int n=arr.length;
        for (int block=1; block<n; block*=2) {
            for (int i=0; i<n; i+=block*2) {
                int l=i;
                int mid=Math.min(i + block, n);
                int r = Math.min(i + 2 * block, n);
                merge_iter(arr, l, mid, r, helper);
            }
            for (int i = 0; i < n; i++) arr[i] = helper[i];
        }
    }

    // right-exclusive
    private static void merge_iter(int[] arr, int l, int mid, int r, int[] helper) {
        int i = l;
        int j = mid;
        int k = l;

        while (i < mid || j < r) {
            if (i < mid && j < r) {
                if (arr[j] > arr[i])
                    helper[k++] = arr[i++];
                else
                    helper[k++] = arr[j++];
            } 
            else if (j == r)
                helper[k++] = arr[i++];
            else
                helper[k++] = arr[j++];
        }
    }

    // checker
    public static void main(String[] args) {
        Random rn = new Random();
        int n = 10;
        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = rn.nextInt(25);
        int[] helper = new int[n];
        System.out.println(Arrays.toString(arr));
        iterativeSort(arr, helper);
        System.out.println(Arrays.toString(arr));
    }
}