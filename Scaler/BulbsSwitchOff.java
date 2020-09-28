// import java.util.*;

public class BulbsSwitchOff {
    public static void main(String[] args) {
        BulbsSwitchOff obj = new BulbsSwitchOff();
        int[] arr = {0 , 1, 0, 1};
        int res = obj.minSwitches(arr);
        System.out.println(res);
    }

    int minSwitches(int arr[]) {
        int s = 0;
        int n = arr.length;
        for (int i=0; i<n; i++) {
            if ((s&1) == 1) {
                if (arr[i] == 1) s++;
            }
            else if (arr[i] == 0) s++;
        }
        return s;
    }
}
