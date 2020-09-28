import java.util.*;

public class QuickSelect {
    int quickSelect(int[] arr, int low, int high, int k) {
        if (k > arr.length || k < 1) return -1;
        while (low < high) {
            int piv = partition(arr, low, high);
            if (piv == k-1) return arr[piv];
            else if (k-1 > piv) partition(arr, piv + 1, high);
            else partition(arr, low, piv - 1);
        }
        return -1;
    }

    void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    int partition(int[] arr, int l, int h) {
        randPivot(arr, l, h);
        int key = arr[h];
        // int i = -1;
        int j = l;
        for (int i=h-1; i>=j;) {
            if (arr[i] < key) {
                swap(arr, i, j);
                j++;
            }
            else i--;
        }
        swap(arr, j, h);
        return j;
    }

    void randPivot(int[] arr, int l, int h) {
        Random rand = new Random();
        int x = rand.nextInt(h - l + 1) + l;
        swap(arr, x, h);
    }

    public static void main(String[] args) {
        int a[] = {9, 7, 4, 1, 5, 41, 99, 109, 76, 85, 67, 56, 49};
        int k = 6;
        QuickSelect obj = new QuickSelect();
        int res = obj.quickSelect(a, 0, a.length - 1, k);
        // Arrays.sort(a);
        // System.out.println(Arrays.toString(a));
        System.out.println(res);
    }
}
