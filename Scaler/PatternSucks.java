// import java.io.*;
import java.util.*;

public class PatternSucks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int edge = scan.nextInt();
        scan.close();
        for(int i=0; i<edge*2; i++) {
            for(int j=0; j<edge*2; j++) {
                if (j<=i) System.out.print("* ");
            }
            System.out.println();
        }
    }
}