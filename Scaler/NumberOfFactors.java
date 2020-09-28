public class NumberOfFactors {
    static int countFactors(int x) {
        int count=0;
        int root = (int)Math.sqrt(x);
        for (int i=1; i<=root; i++) {
            if (i*i == x) count++;
            else if (x%i == 0) count+=2;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countFactors(4));
    }
}
