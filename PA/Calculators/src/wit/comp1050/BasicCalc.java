package wit.comp1050;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BasicCalc implements SimpleCalc {

    @Override
    public long add(int a, int b) {
        return a+b;
    }

    @Override
    public long sub(int a, int b) {
        return a-b;
    }

    @Override
    public BigInteger mul(int a, int b) {
        return BigInteger.valueOf((long) ((double) a*b));
    }

    @Override
    public BigDecimal div(int a, int b) {

        return BigDecimal.valueOf(((float) a/b));
    }

}
