public class ReverseBits {
    static int reverse(int A) {
        if (A == 0) return 0;
        int rev = 0;
        for (int i=0; i<32; i++) {
            rev <<= 1;
            // if ((A&1) == 1) rev |= 1;
            rev |= A&1; //Same as above
            A >>= 1;
        }
        return rev;
    }
}
