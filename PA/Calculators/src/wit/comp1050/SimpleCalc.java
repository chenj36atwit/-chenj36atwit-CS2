package wit.comp1050;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface SimpleCalc {

    long add(int a, int b);         // a + b
    long sub(int a, int b);         // a - b
    BigInteger mul(int a, int b);   // a * b
    BigDecimal div(int a, int b);   // a / b, if b==0, throws IllegalArgumentException

}
