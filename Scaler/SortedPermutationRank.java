import java.util.Arrays;

public class SortedPermutationRank {

    // O(n) runtime, O(256) or O(1) space
    static int findRank(String str) {
        int[] count= new int[256];
        int rank = 1;
        Arrays.fill(count, 0);
        char[] arr = str.toCharArray();
        int len = arr.length;
        long perms = factorial(len);
        // System.out.println(perms);

        // Count Array
        for (int i=0; i<len; i++) count[arr[i]]++;
        for (int i=1; i<256; i++) count[i] += count[i-1];
        // System.out.println(Arrays.toString(count));

        for (int i=0; i<len; i++) {
            perms /= len - i;
            rank += count[arr[i] - 1] * perms;
            updateCount(count, arr[i]);
        }
        // return rank; 
        return rank%1000003; //or for huge int > 1000003
    }

    static long factorial(long n) {
        if (n < 0) return -1;
        return (n < 2) ? 1 : n*factorial(n-1); 
    }

    static void updateCount(int[] count, char ch) {
        for (int i=ch; i<256; i++) --count[i];
    }

    // O(n^2)
    static long findLexRank(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length; 
        long rank = 1;
        for (int i=0; i<len; i++) {
            int count=0;
            for (int j=i+1; j<len; j++) {
                if (arr[i] > arr[j]) count++;
            }
            rank += count*factorial(len - 1 - i);
        }
        return rank%1000003;
    }

    public static void main(String[] args) {
        String str = "DTNGJPURFHYEW";
        String str2 = "ZCSFLVHXRYJQKWABGT";
        System.out.println(findRank(str));
        System.out.println(findLexRank(str2));
    }
}
