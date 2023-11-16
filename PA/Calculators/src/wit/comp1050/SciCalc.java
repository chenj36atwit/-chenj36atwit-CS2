package wit.comp1050;

import java.math.*;

class SciCalc extends BasicCalc {

    public int sqrt(int n) {

        return (int) Math.sqrt(n);

    }
    public BigInteger pow(int n, int p) {

        BigInteger bi1, bi2;

        int exponent = p;

        bi1 = new BigInteger(String.valueOf(n));

        bi2 = bi1.pow(exponent);

        return bi2;

    // returns n^p (n raised to the power of p)
    }
}
