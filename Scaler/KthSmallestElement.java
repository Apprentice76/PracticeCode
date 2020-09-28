import java.util.Arrays;

public class KthSmallestElement {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int n = A.length;
        int max = A[0];
        int min = A[0];
        int[] x = new int[n];
        if (B > n || B < 1) return -1;
        for (int i=0; i<n; i++) {
            x[i] = A[i];
            if (max < A[i]) max = A[i];
            if (min > A[i]) min = A[i];
        }
        if (B == 1) return min;
        if (max == 0) return 0;
        Arrays.sort(x);
        return x[B-1];
    }
}