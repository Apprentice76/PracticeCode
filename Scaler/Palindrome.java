public class Palindrome {
    static int isPalindrome(long A) {
            long rev = 0;
            long n = A;
            while (n > 0) {
                long r = n%10;
                rev = 10*rev + r;
                n /= 10;
            }
            // System.out.println(rev);
            if (A == rev) return 1;
            return 0;
    }
    public static void main(String[] args) {
        // isPalindrome(1010676010);
    }
}
