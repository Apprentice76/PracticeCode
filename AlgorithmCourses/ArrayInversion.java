import java.util.Arrays;

public class ArrayInversion {
    static int inv_t = 0;
    static int inversions(int[] arr, int[] helper, int l, int r) {
        inv_t = recursiveSort(arr, l, r, helper);
        // inv_t = iterativeSort(arr, helper);
        return inv_t;
    }

    static int recursiveSort(int[] arr, int l, int r, int[] helper) {
        int inv=0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            inv += recursiveSort(arr, l, mid, helper);
            inv += recursiveSort(arr, mid + 1, r, helper);
            inv += merge(arr, l, mid, r, helper);
        }
        return inv;
    }

    // right-inclusive
    private static int merge(int[] arr, int l, int mid, int r, int[] helper) {
        int i = l;
        int j = mid + 1;
        int k = l;
        int inv = 0;

        while (i <= mid || j <= r) {
            if (i <= mid && j <= r) {
                if (arr[i] <= arr[j]) {
                    helper[k++] = arr[i++];
                }
                else {
                    helper[k++] = arr[j++];
                    inv += mid + 1 - i;
                }
            } else if (j > r)
                helper[k++] = arr[i++];
            else
                helper[k++] = arr[j++];
        }

        for (i = l; i < r + 1; i++)
            arr[i] = helper[i];
        return inv;
    }


    public static int iterativeSort(int[] arr, int[] helper) {
        int n = arr.length;
        int inv = 0;
        for (int block = 1; block < n; block *= 2) {
            for (int i = 0; i < n; i += block * 2) {
                int l = i;
                int mid = Math.min(i + block, n);
                int r = Math.min(i + 2 * block, n);
                inv += merge_iter(arr, l, mid, r, helper);
            }
            for (int i = 0; i < n; i++)
                arr[i] = helper[i];
        }
        return inv;
    }

    // right-exclusive
    private static int merge_iter(int[] arr, int l, int mid, int r, int[] helper) {
        int i = l;
        int j = mid;
        int k = l;
        int rev = 0;
        while (i < mid || j < r) {
            if (i < mid && j < r) {
                if (arr[i] <= arr[j])
                    helper[k++] = arr[i++];
                else {
                    helper[k++] = arr[j++];
                    rev += mid - i;
                }
            } else if (j == r)
                helper[k++] = arr[i++];
            else
                helper[k++] = arr[j++];
        }
        return rev;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 4, 2, 1 , 5};
        int[] helper = new int[arr.length];
        System.out.println(inversions(arr, helper, 0, arr.length - 1));
        // inversions(arr, helper, 0, 3);
        System.out.println(Arrays.toString(arr));
    }
}
