import java.util.*;

public class Google {

    public String stringSplosion(String str) {
    int n=str.length();
    String res="";
    for (int i=0; i<n; i++) {
        res +=str.substring(0, i+1);
    }
    // char c = res.charAt(1);
    return res;
    }

    public int maxSpan(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        int span = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = 0;
                if (nums[i] == nums[j]) {
                    tmp = j - i + 1;
                }
                span = Math.max(tmp, span);
            }
        }
        return span;
    }

    public String withoutString(String base, String remove) {
        return base.replaceAll("(?i)" + remove, "");
    }


    public int sumNumbers(String str) {
        String tmp = "0";
        int res = 0;
        int n = str.length();
        // String[] nums = str.replaceAll("(?i)[A-Z]", "").split("")
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c))
                tmp += c;
            else {
                res += Integer.parseInt(tmp);
                tmp = "0";
            }
        }
        return res + Integer.parseInt(tmp);
    }

    public boolean canBalance(int[] nums) {
        int n=nums.length;
        int i=0, j=n-1;
        int l_sum=nums[i], r_sum=nums[j];
        while(j>i) {
            if ((l_sum == r_sum) && ((i+1)==j)) return true;
            else if (l_sum < r_sum) l_sum+=nums[++i];
            else r_sum+=nums[--j];
        }
        // System.out.println(l_sum);
        return false;
    }

    int[] sortWithoutDups(int[] a) {
        int n=a.length;
        if (n < 2) return a;
        Arrays.sort(a);
        int dups=0;
        int i, j;
        for (i=1; i<n; i++) {
            if (a[i-1] == a[i]) dups++;
        }
        int[] res = new int[n-dups];
        for (j=0, i=0 ; i<n-1; i++) if (a[i] != a[i+1]) res[j++] = a[i];
        res[j] = a[n-1];
        return res;
    }

    public int interpret(int value, String[] commands, int[] args) {
        int n = commands.length;
        for (int i = 0; i < n; i++) {
            switch (commands[i]) {
                case "+":
                    value += args[i];
                    break;
                case "*":
                    value *= args[i];
                    break;
                case "-":
                    value -= args[i];
                    break;
                default:
                    return -1;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Google o = new Google();
        int[] nums = {1, 1, 1, 2, 1};
        System.out.println(o.canBalance(nums));
    }

}