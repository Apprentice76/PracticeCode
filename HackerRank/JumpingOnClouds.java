public class JumpingOnClouds {
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int n = c.length;
        int pos = 0;
        while (pos < n - 1) {
            if (pos < n - 2 && (c[pos + 2] == 0))
                pos += 2;
            else
                pos++;
            jumps++;
        }
        return jumps;
    }
}
