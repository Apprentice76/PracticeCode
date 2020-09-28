public class GFG {
    static int specialString(String s) {
        int replacements = 0;
        // char[] str = s.toCharArray();
        char max = 'a';
        char min = 'z';
        int same = 0;
        int max_r = 0, min_r = 0;
        // int same_r = 0;
        int n = s.length();
        for (int i=0; i<n/2; i++) {
            char c = s.charAt(i);
            char next = s.charAt(i+n/2);
            if (c > max) max = s.charAt(i);
            if (c != next) same++;
            if (c < min) min = s.charAt(i);
        }
        System.out.println(max);
        for (int i=n/2; i<n; i++) {
            if (!(s.charAt(i) < max)) max_r++;
            if (!(s.charAt(i) > max)) min_r++;
        }
        replacements = Math.min(max_r, min_r);
        return Math.min(replacements, same);
    }

    public static void main(String[] args) {
        String s = "aababc";
        System.out.println(specialString(s));
    }
}
