public class ArrayLeftRotate {
    static int[] rotLeft(int[] a, int d) {
        int n=a.length;
        int[] tmp = new int[n];
        for (int i=0; i<n; i++) {
            int loc = (i+d)%n;
            tmp[i] = a[loc];
        }
        return tmp;
    }
}
