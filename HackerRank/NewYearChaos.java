public class NewYearChaos {
    static void minimumBribes(int[] q) {
        int n = q.length;
        int bribe = 0;
        int rightPos = 1;
        int plusOne = 2;
        int plusTwo = 3;
        for (int i = 0; i < n; i++) {
            if (q[i] == rightPos) {
                rightPos = plusOne;
                plusOne = plusTwo;
                plusTwo++;
            } else if (q[i] == plusOne) {
                bribe++;
                plusOne = plusTwo;
                plusTwo++;
            } else if (q[i] == plusTwo) {
                bribe += 2;
                plusTwo++;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(bribe);
    }
}
