// import java.util.Arrays;

public class PrimeSum {
    public static int[] primesum(int A) {
        int f = -1;
        for (int i=1; i<=A; ) {
            // System.out.println(i + " " + (A-i));
            if (isPrime(i) && isPrime(A-i)) {
                return new int[] {i, A-i};
            }
            else i++;
        }
        return new int[] {f};
    }
    
    static boolean isPrime(int a) {
        if (a < 2) return false;
        int root = (int)Math.sqrt(a);
        for (int i=2; i<=root + 1; i++) {
            if (a%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(12));
    }
}
