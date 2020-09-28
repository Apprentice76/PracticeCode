public class RotateArray90 {
    public void solve(int[][] A) {
        int n = A.length;
        for (int i=0; i<n; i++)
            for (int j=i+1; j<n; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        
        for (int i=0; i<n; i++)
            for (int j=0; j<n/2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][n-j-1];
                A[i][n-j-1] = temp;
            }
    }
}