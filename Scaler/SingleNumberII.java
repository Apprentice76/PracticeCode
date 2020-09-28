public class SingleNumberII {
    static int[] getUniquesNums(int[] A) {
        int xor = A[0];
        int n = A.length;
        for (int i=1; i<n; i++) {
            xor^=A[i];
        }
        int set_bit = 1;
        int set1 = 0;
        int set2 = 0;
        while((set_bit&xor) != set_bit) {
            set_bit <<= 1;
        }
        for (int i=0; i<n; i++) {
            if ((set_bit&A[i]) == set_bit) {
                if (set1 == 0) set1 = A[i];
                else set1^=A[i];
            }
            else {
                if (set2 == 0) set2 = A[i];
                else set2^=A[i];
            }
        }
        if (set1 < set2) return new int[] {set1, set2};
        return new int[] {set2, set1};
    }
    
}
