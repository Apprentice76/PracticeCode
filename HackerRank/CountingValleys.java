public class CountingValleys {
    public static int countingValleys(int steps, String path) {
        int alt = 0, prev_alt = 0;
        int valleys = 0;
        for (int i = 0; i < steps; i++) {
            char step = path.charAt(i);
            if (step == 'U')
                alt++;
            else if (step == 'D')
                alt--;
            if ((alt == 0) && (prev_alt == -1))
                valleys++;
            prev_alt = alt;
        }
        return valleys;
    }
}
