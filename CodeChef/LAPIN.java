import java.util.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            char arr[] = str.toCharArray();
            System.out.println(checkLapin(arr));
        }
        sc.close();
    }
    
    static String checkLapin(char[] arr) {
        int size = arr.length;
        // System.out.println(Arrays.toString(arr));
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int ptr = size/2;
        if ((size&1) == 1) ptr++;
        for (int i=0; i<size/2; i++, ptr++) {
            map1.put(arr[i], map1.getOrDefault(arr[i], 0) + 1);
            map2.put(arr[ptr], map2.getOrDefault(arr[ptr], 0) + 1);
        }
        for (char c: map1.keySet()) {
            int val2 = map2.getOrDefault(c, 0);
            int val1 = map1.get(c);
            if (val2 != val1) return "NO";
        }
        return "YES";
    }
}