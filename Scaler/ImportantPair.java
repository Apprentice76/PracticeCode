import java.util.Arrays;

public class ImportantPair {
    // naive
    public int countPairs(int[] A) {
        int n = A.length;
        int count = 0;
        for (int i=0; i<n; i++)
            for (int j=i+1; j<n; j++)
                if (A[i] > 2*A[j]) count++;
        return count;
    }

    int customMergeSort(int[] arr, int l, int r) {
        int m, pair_count=0;
        if (l < r) {
            m = (l+r)/2;
            pair_count = customMergeSort(arr, l, m) + customMergeSort(arr, m+1, r);
            for (int i=l, j=m+1; i<=m; i++) {
                while (j<=r && arr[i] > 2*arr[j]) j++;
                pair_count += j - m - 1;
            }
            merge(arr, l, m, r);
        }
        return pair_count;
    }

    void merge(int[] arr, int l, int m, int r) {
        int i = 0;
        int j = 0;
        int k = l;
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
  
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);  
        // Merge in ascending

        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
            } 
        } 
  
        while (i < left.length) 
            arr[k++] = left[i++]; 
  
        while (j < right.length) 
            arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        // int[] X = {8, 4, 2, 1, 7, 0, 2};
        int[] A = {14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380, 78549, 57512, 33137, 81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044, 78056, 45190, 94365, 58869, 20611};
        // int[] helper = new int[A.length];
        ImportantPair obj = new ImportantPair();
        System.out.println(obj.countPairs(A));
        System.out.println(obj.customMergeSort(A, 0, A.length - 1));
        System.out.println(Arrays.toString(A));
    }
}
