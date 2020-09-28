import java.util.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=1; i<101; i++) map.put(i, 0);
        for (int i=0; i<n; i++) {
            map.put(ar[i], map.get(ar[i]) + 1);
        }
        int pairs=0;
        for (int i: map.keySet()) {
            int val = map.get(i);
            pairs += val/2; 
        }
        return pairs;
    }
}