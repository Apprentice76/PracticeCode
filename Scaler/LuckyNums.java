public class LuckyNums {
    public int luckyCount(int A) {
        int count = 0;
        for (int i=6; i<=A; i++) {
            if (isPrime(i)) continue;
            else if (checkLucky(i)) count++;
        }
        return count;
    }
    boolean checkLucky(int x) {
        int count = 0;
        for (int i=2; i<=x/2; i++) {
            if (count > 2) return false;
            else if (x%i==0 && isPrime(i)) {
                count++;
            }
        }
        if (count == 2) return true;
        return false;
    }
    
    boolean isPrime(int num) {
        if (num < 2) return false;
        int root = (int)Math.sqrt(num);
        for (int i=2; i<=root; i++) {
            if (num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LuckyNums obj = new LuckyNums();
        // System.out.println(obj.checkLucky(6));
        System.out.println(obj.luckyCount(12));
    }
}