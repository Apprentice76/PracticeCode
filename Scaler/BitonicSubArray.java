// import java.io.*;
import java.util.*;

public class BitonicSubArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++)
            arr[i] = scan.nextInt();
        scan.close();

        if (size < 3) System.out.println(size);
        else {
            int seq=1, flag=0, max=0;
            
            for(int i=0; i<size-1; i++) {
                if (arr[i]<arr[i+1]) {
                    if (flag==0)
                        seq++;
                    else if (flag==1) {
                        flag = 0;
                        max = (max > seq) ? max : seq;
                        seq = 2;
                    }
                }
                else if (arr[i]>arr[i+1]) {
                    flag = 1;
                    seq++;
                    max = (max > seq) ? max : seq;
                }
            }

            System.out.println(max);
        }
    }   
}