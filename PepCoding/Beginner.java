
import java.util.*;

public class Beginner {
    void printZ(int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 || i == (n-1)) System.out.print('*');
                else if (j == (n-1)-i) System.out.print('*');
                else System.out.print(' ');
            }
            System.out.println();
        }
    }

    boolean isPrime(int x) {
        for (int i=0; i*i<x; i++) {
            if (x%i == 0) return false;
        }
        return true;
    }

    int MAX = 1000001;
    boolean[] prime = new boolean[MAX];

    void sieveOfEratosthenes() {
        prime[0] = false;
        prime[1] = false;
        for (int i=2; i < MAX; i++) {
            prime[i] = true;
        }
        for (int i=2; i*i<MAX; i++) {
            if (prime[i] == true) {
                for (int j=i*i; j<MAX; j+=i) prime[j] = false;
            }
        }
    }

    void printPrimesTill(int x) {
        sieveOfEratosthenes();
        for (int i=2; i<x+1; i++) if (prime[i] == true) System.out.print(i + " ");
    }

    void fibonacci(int x) {
        int n = x-2;
        int f=1, s=1;
        if (x > 2) {
            System.out.print("1 1 ");
            for (int i=0; i<n; i++) {
                int curr = f+s;
                System.out.print(curr + " ");
                f = s;
                s = curr;
            }
        }
        else
            for (int i=0; i<x; i++) System.out.print(1 + " ");

    }

    void digits(int x) {
        if (x == 0) System.out.print('0');
        while (x > 0) {
            System.out.println(x%10);
            x/=10;
        }
    }

    void printInverse(int x) {
        char[] arr = Integer.toString(x).toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int n = arr.length;
        // int[] res = new int[n];
        // for (int i=0; i<n; i++) res[i] = Integer.parseInt(arr[i]);
        for (int i=0; i<n; i++) {
            map.put(arr[n-i-1], i);
        }
        // map.forEach((k, v) -> res[v] = k);
    }


    public static void main(String[] args) {
        Beginner o = new Beginner();
        // o.printZ(10);
        // o.printPrimesTill(100);
        o.fibonacci(10);
        // String sub = "stry";
        // CharSequence tr = sub.subSequence(1, 3);
    }    
}