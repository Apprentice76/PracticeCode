public class MaxSubArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int currMax = A[0];
        int globMax = A[0];
        int n = A.length;
        // Kadane's algo
        for (int i=1; i<n; i++) {
            currMax = Math.max(A[i], A[i] + currMax);
            globMax = Math.max(currMax, globMax);
        }
        return globMax;
    }
}
