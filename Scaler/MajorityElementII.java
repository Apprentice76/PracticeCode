import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        // int[] arr = new int[n];
        // for (int i=0; i<n; i++) {
        //     arr[i] = scan.nextInt();
        // }
        scan.close();
        int[] arr = {0,4,0,0,4,4,3,3,4};
        MajorityElementII var = new MajorityElementII();
        List<Integer> result = var.majElement(arr);
        System.out.println(result);
    }

    List<Integer> majElement(int[] A) {
        int n = A.length;
        int el1 = -1, el2 = -1;
        int count1 = 0, count2 = 0;
        for (int i=0; i<n; i++) {
            if (A[i] == el1) count1++;
            else if (A[i] == el2) count2++;
            else if (count1 == 0) {
                el1 = A[i];
                count1 = 1;
            }
            else if (count2 == 0) {
                el2 = A[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        List<Integer> majElements = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        while (--n >= 0) {
            if (A[n] == el1) count1++;
            else if (A[n] == el2) count2++;
        }
        n = A.length;
        // System.out.println(count1);
        if (count1 > n/3) majElements.add(el1);
        if (count2 > n/3) majElements.add(el2);
        if (majElements.isEmpty()) return new ArrayList<Integer>(Arrays.asList(-1));
        return majElements;
    }
}