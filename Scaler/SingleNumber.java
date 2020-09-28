public class SingleNumber {
    static int singleNumber(final int[] A) {
        int res = A[0];
        int n = A.length;
        for (int i=1; i<n; i++) {
            res^=A[i];
        }
        return res;
    }
}
