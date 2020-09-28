public class MinimumSwapsTwo {
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int n = arr.length;
        for (int i = 0; i < n;) {
            if (1 + i == arr[i])
                i++;
            else {
                int tmp = arr[i];
                arr[i] = arr[tmp - 1];
                arr[tmp - 1] = tmp;
                swaps++;
                if (swaps == n - 1)
                    break;
            }
        }
        return swaps;
    }
}