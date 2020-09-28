// import java.util.Arrays;
import java.util.*;

public class VisibleBottles {
    int countBottles(int[] A) {
            int count = -1;
            int n = A.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i=0; i<n; i++) {
                int key = A[i];
                map.put(key, map.getOrDefault(key, 0) + 1);
                int val = map.get(key);
                if (val > count) count = val;
            }
            return count;
    }
    

    public static void main(String[] args) {
        int[] a = {8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3, 8, 17, 12, 5, 3, 14, 13, 3, 2, 17, 19, 16, 8, 7, 12, 19, 10, 13, 8, 20, 16, 15, 4, 12, 3};
        VisibleBottles obj = new VisibleBottles();
        System.out.println(obj.countBottles(a));
    }
}
