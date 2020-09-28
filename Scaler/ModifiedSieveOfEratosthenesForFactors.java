public class ModifiedSieveOfEratosthenesForFactors {
    static int MAX = 1000001;
    static int[] factors = new int[MAX];
    static void generateLowestPrimeFactor() {
        factors[0] = 0;
        factors[1] = 1;
        // Setting the number as of themselves
        for (int i=2; i<MAX; i++) factors[i] = i;
        // Marking factors of 2, 3
        for (int i=4, j=6; i<MAX; i+=2, j+=3) {
            factors[i] = 2;
            if (j<MAX) factors[j] = 3;
        }
        for (int i=5; i*i < MAX; i++) {
            if (factors[i] == i) {
                for (int j=i*i; j<MAX; j+=i) // Jumps for a prime number starting from its square.
                    if (factors[j] == j)     // But changing only those which are not prime.
                        factors[j] = i; 
            }
        }
    }

    
}
