import java.util.Arrays;

public class CountFactors extends ModifiedSieveOfEratosthenesForFactors {
    // naive O(N*N^1/2)
    static int factors(int x) {
        int count=0;
        int root=(int)Math.sqrt(x);
        for (int i=1; i<root+1; i++) {
            if (i*i == x) count++;
            else if (x%i == 0) count+=2;
        }
        return count;
    }

    static int[] facCount(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        Arrays.fill(res, 2);
        for (int i=0; i<n; i++) {
            res[i] = factors(A[i]);
        }
        return res;
    }
    

    // Factor count with sieve O(Nlog(log(N)))
    static int factorCount(int num) {
        if (num == 1) return 1;
        int ans=1;
        int a = factors[num];
        int count=1;
        int j = num/factors[num];
        while (j != 1) {
            if (factors[j] == a) {
                count++;
            }
            else {
                a = factors[j];
                ans *= (count + 1); // Number Theory Formula
                count = 1;
            }
            j /= factors[j];
        }
        ans *= (count + 1); // For last prime divisor
        return ans;
    }

    static int[] factorCountInArray(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = factorCount(A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        generateLowestPrimeFactor();
        // int[] A = {5, 87, 98, 56, 72};
        int[] B = {2, 3, 4, 5};
        // System.out.println(factorCount(72));
        System.out.println(Arrays.toString(factorCountInArray(B)));
    }
}
