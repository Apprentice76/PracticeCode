public class MinimumUnsortedSubarray {
    public int[] subUnsort(int[] A) {
        int n = A.length;
        int start = 0;
        int end = n-1;
        for (start=0; start<n-1; start++) {
            if (A[start] > A[start + 1]) break;  
        }
        if (start == n-1) return new int[] {-1};
        
        for (; end>0; end--) {
            if (A[end-1] > A[end]) break;
        }
        
        int max = A[start]; 
        int min = A[start];
        
        
        for (int i=start+1; i<=end; i++) {
            max = Math.max(A[i], max);
            min = Math.min(A[i], min);
        }
        
        for (int i=0; i<start; i++) {
            if (A[i] > min) {
                start = i;
                break;
            }
        }
        
        for (int i=n-1; i>end; i--) {
            if (A[i] < max) {
                end = i;
                break;
            }
        }
        
        return new int[] {start, end};
    }
}
