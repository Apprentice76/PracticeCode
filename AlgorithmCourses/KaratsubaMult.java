import java.math.BigInteger;

public class KaratsubaMult {
    static int calls = 0;
    static BigInteger multiply(BigInteger x, BigInteger y, int i) {
        calls++;
        BigInteger min = x.min(y);
        if (x != min) {
            y = x;
            x = min;
        }
        if (x.equals(BigInteger.ONE)) return y;
        if (x.min(new BigInteger("10")) == x) return x.multiply(y);
        long len = Math.max(checkLen(x), checkLen(y));
        BigInteger multiplier = (new BigInteger("10")).pow((int)Math.ceil((double) len / 2.0));
        BigInteger a = x.divide(multiplier);
        BigInteger b = x.subtract(a.multiply(multiplier));
        BigInteger c = y.divide(multiplier);        
        BigInteger d = y.subtract(c.multiply(multiplier));
        System.out.println("a: " + a + " b: " + b + " c: " + c + " d: "+ d);
        BigInteger var1 = multiply(a, c, i+1);
        BigInteger var2 = multiply(b, d, i+1);
        return multiplier.pow(2).multiply(var1).add(var2).add(multiplier.multiply(multiply(a.add(b), c.add(d), i+1).subtract(var1.add(var2))));
    }

    static long checkLen(BigInteger x) {
        return x.toString().length();
    }

    public static void main(String[] args) {
        BigInteger x = new BigInteger("759475478798349863898038946898390489068409");
        BigInteger y = new BigInteger("934038847329997384922998582948928598298959");
        BigInteger res = multiply(x, y, 1);
        System.out.println("\nresult: " + res + "; calls: " + calls);
    }
}