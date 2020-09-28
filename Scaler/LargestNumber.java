import java.util.*;

public class LargestNumber {
    String solution(int[] arr) {
        int n = arr.length;
        
        String res = "";
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                String a = Integer.toString(arr[i]);
                String b = Integer.toString(arr[j]);
                int cmp1 = Integer.parseInt(a+b);
                int cmp2 = Integer.parseInt(b+a);
                if (cmp1 < cmp2) swap(arr, i, j);
            }
            res += Integer.toString(arr[i]);
        }
        return res;
    }

    void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) {
        LargestNumber c = new LargestNumber();
        int[] arr = {1, 2, 31, 900, 89};
        String res = c.solution(arr);
        System.out.println(res);
    }
}


// Library func

class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A) {
        int max = 0;
        int n = A.length;
        for (int i=0; i<n; i++) if (A[i] > max) max = A[i];
        if (max == 0) return "0";
        String[] B = new String[n];
        for (int i=0; i<n; i++) B[i] = String.valueOf(A[i]);
        String res = "";
        Arrays.sort(B, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String ab = a+b;
                String ba = b+a;
                return ba.compareTo(ab) > 0 ? 1:-1;
            }
        });
        for (int i=0; i<n; i++) res+=B[i];
        return res;
    }
}

