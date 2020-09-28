import java.util.Arrays;

public class WaveformSort {
    void wiggleSort(int[] arr) {
        int n = arr.length;
        for (int i=1; i<n-1; i+=2) {
            if (arr[i-1] < arr[i]) swap(arr, i-1, i);
            if (arr[i] > arr[i+1]) swap(arr, i, i+1);
        }
    }

    public int[] lexicalWaveSort(int[] A) {
        int n = A.length;
        int B[] = new int[n];
        for (int i=0; i<n; i++) B[i] = A[i];
        Arrays.sort(B);
        for (int i=0; i<n-1; i+=2) {
            swap(B, i, i+1);
        }
        return B;
    }

    void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        WaveformSort obj = new WaveformSort();
        obj.wiggleSort(A);
        System.out.println(Arrays.toString(A));
    }
}
