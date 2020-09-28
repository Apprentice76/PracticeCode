import java.util.Arrays;

public class ArrayInversions {
    public int countInversions(int[] A) {
        int n = A.length;
        int count_inv = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (A[i] > A[j]) count_inv++;
            }
        }
        return count_inv;
    }

    int customMergeSort(int[] arr, int l, int r) {
        int m, inv_count=0;
        if (l < r) {
            m = (l+r)/2;
            inv_count = customMergeSort(arr, l, m);
            inv_count += customMergeSort(arr, m+1, r);
            inv_count += merge(arr, l, m, r);
        }
        return inv_count;
    }

    int merge(int[] arr, int l, int m, int r) {
        int i = 0;
        int j = 0;
        int k = l;
        int inv_count = 0;
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
  
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);  
        // Merge in ascending

        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                inv_count += (m + 1) - (l + i); 
            } 
        } 
  
        while (i < left.length) 
            arr[k++] = left[i++]; 
  
        while (j < right.length) 
            arr[k++] = right[j++];

        
        return inv_count;
    }

    public static void main(String[] args) {
        int[] A = {8, 4, 2, 1};
        // int[] helper = new int[A.length];
        ArrayInversions obj = new ArrayInversions();
        System.out.println(obj.countInversions(A));
        System.out.println(obj.customMergeSort(A, 0, A.length - 1));
        System.out.println(Arrays.toString(A));
        
        
    }
}