import java.util.ArrayList;

import java.util.*;

public class CountSetBits {
    static int countBits(int n) {
        int total = 0;
        // if (n < 3) return 1;
        List<Integer> list = new ArrayList<>();
        int num = n;
        int i=0;
        while (num != 0) {
            if ((num&1) == 1) {
                list.add(i);
            }
            i++;
            num >>= 1;
        }
        System.out.println(list);
        for (i=0; i<list.size(); i++) {
            int val = list.get(i);
            if (val == 0) total = 1;
            else if (val == 1) total += 2;
            else // if (val > 1)
                total += (Math.pow(2, val - 1) * (val)) + 1;
        }
        return total;
    }
    public static void main(String[] args) {
        int res = countBits(16);
        System.out.println(res);
    }
}
