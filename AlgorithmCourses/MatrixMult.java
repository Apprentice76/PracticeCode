public class MatrixMult {
    int[][] multiply(int[][] A, int[][] B) {
        if (A[0].length != B.length) return new int[][] {{-1}};
        int[][] C = new int[A.length][B[0].length];
        for (int i=0; i<A.length; i++)
            for (int j=0; j<B[0].length; j++) 
                for (int k=0; k<A[0].length; k++) 
                    C[i][j] += A[i][k]*B[k][j];
        return C;
    }
}
    