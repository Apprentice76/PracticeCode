import java.util.Arrays;

public class MergeSort {
    static void merge(int[] arr, int[] helper, int l, int m, int r) {
        int i=l;
        int j=m;
        int k=l;

        while (i<m || j<r) {
            if (i<m && j<r) {
                if (arr[i]<arr[j]) helper[k++] = arr[i++];
                else helper[k++] = arr[j++];
            }
            else if (i==m) helper[k++] = arr[j++];
            else if (j==r) helper[k++] = arr[i++];
        }
        for (i=l; i<r; i++) arr[i] = helper[i];
        // System.out.println(Arrays.toString(helper));
    }

    static void mersort(int[] arr, int[] helper, int l, int r) {
        if (r-l==1) return;
        int m = (r+l)/2;
        mersort(arr, helper, l, m);
        mersort(arr, helper, m, r);
        merge(arr, helper, l, m, r); 
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {100, 7, 8, 4, 2, 9, 6, 5, 1, 6, 10, 11};
        int[] helper = new int [arr.length];
        mersort(arr, helper, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}