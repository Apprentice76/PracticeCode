// import java.io.*;
import java.util.*;

public class BitonicSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++)
            arr[i] = scan.nextInt();
        scan.close();
        
        if (size<2) System.out.println(size);
        else {
        int[] seqSize = new int[size];
        Arrays.fill(seqSize, 1);
        int[] seqSize2 = new int[size];
        Arrays.fill(seqSize2, 1); // For Reverse
        int max=1;
        
        for (int i=1; i<size; i++)    // Forward Sequence
            for (int j=0; j<i; j++)
                if (arr[i]>arr[j] && seqSize[i] < seqSize[j] + 1)  // seqSize[i] < seqSize[j] + 1 is important for preventing
                    seqSize[i] = seqSize[j] + 1;                   // summing when ith index is more than j but sub sequence
                                                                   // might not necessarily be in order
        for (int i=size-2; i>=0; i--) // Reverse Sequence
            for (int j=size-1; j>i; j--)
                if (arr[i]>arr[j] && seqSize2[i] < seqSize2[j] + 1)
                    seqSize2[i] = seqSize2[j] + 1;

        // System.out.println(Arrays.toString(seqSize));
        
        for (int i=0; i<size; i++) max = (max > seqSize[i] + seqSize2[i] - 1) ? max : seqSize[i] + seqSize2[i] - 1;
        
        System.out.println(max);
        }
    }   
}