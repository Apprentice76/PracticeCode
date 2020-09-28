import java.util.Arrays;

public class SelectionSort {
    static int[] selsort(int[] arr) {
        int size = arr.length;
        for(int i=0; i<size; i++) {
            int min = i;
            for (int j=i+1; j<size; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {1 , 7, 8, 4, 2, 6, 9, 0, 3, 2};
        System.out.println(Arrays.toString(selsort(arr)));
    }
}