import java.util.*;

public class SortedMatrixSearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        // int m = scan.nextInt();
        // int[][] mat = new int[n][m];
        // for (int i=0; i<n; i++)
        //     for (int j=0; j<m; j++)
        //         mat[i][j] = scan.nextInt();
        // int s = scan.nextInt();
        int[][] mat = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
        int s = 50;
        SortedMatrixSearch obj = new SortedMatrixSearch();
        List<Integer> res = obj.sMatSearch(mat, s);
        System.out.println(res);
        scan.close();
    }    

    List<Integer> sMatSearch(int[][] arr, int el) {
        List<Integer> loc = new ArrayList<>();
        int i = 0;
        int j = arr[0].length - 1;
        while (i < arr.length && j >= 0) {
            int pointer = arr[i][j];
            if (el == pointer) {
                loc.add(i);
                loc.add(j);
                break;
            }
            else if (el > pointer) i++;
            else j--;
        }
        if (loc.isEmpty()) return new ArrayList<Integer>(Arrays.asList(-1, -1));
        return loc;
    }

    public int solve(int[][] A, int B) {
        int add = -1;
        int i = 0;
        int j = A[0].length - 1;
        while (i < A.length && j >= 0) {
            int pointer = A[i][j];
            if (B == pointer) {
                add = (i+1)*1009 + j+1;
                break;
            }
            else if (B > pointer) i++;
            else j--;
        }
        return add;
    }
}