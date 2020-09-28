public class RepeatedString {
    static long repeatedString(String s, long n) {
        int sub_size = s.length();
        if (sub_size > n) {
            s = s.substring(0, (int) n);
            n = sub_size;
        }
        int counter_p = 0;
        for (char a : s.toCharArray())
            if (a == 'a')
                counter_p++;
        long last = 0;
        int counter_l = 0;
        if (sub_size < n) {
            last = n % sub_size;
            for (int i = 0; i < last; i++)
                if (s.charAt(i) == 'a')
                    counter_l++;
        }
        return counter_p * (n / sub_size) + counter_l;
    }
}
