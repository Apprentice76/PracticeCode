import java.util.*;

public class CF4AWatermelon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();
        possibleEven(size);
    }

    static void possibleEven(int a) {
        if ((a & 1) == 1) {
            System.out.println("NO");
            return;
        }
        for (int i=2; i<a; i+=2) {
            if (((a-i) & 1) == 0) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
