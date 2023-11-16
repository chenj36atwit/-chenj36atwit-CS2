package wit.comp1050;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wit.comp1050.Fraction;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorsTest {

    // Basic Calc
    @Test
    public void bcAdd() {
        BasicCalc bc = new BasicCalc();
        long result = bc.add(123, 654);
        assertEquals(777, result);
    }
    @Test
    public void bcSub() {
        BasicCalc bc = new BasicCalc();
        long result = bc.sub(83847, 6393);
        assertEquals(77454, result);
    }
    @Test
    public void bcMul() {
        BasicCalc bc = new BasicCalc();
        long result = bc.mul(123, 654).longValue();
        assertEquals(80442, result);
    }
    @Test
    public void bcDiv() {
        BasicCalc bc = new BasicCalc();
        double result = bc.div(99, 89).doubleValue();
        assertEquals(1.112, result, 0.001);
    }
    @Test void bcDivZero() {
        BasicCalc bc = new BasicCalc();
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    bc.div(99, 0).doubleValue();
                });
    }

    // SciCalc
    @Test
    public void scSqrt()
    {
        SciCalc sc = new SciCalc();
        double result = sc.sqrt(25);
        assertEquals(5.0, result, 0.001);
    }
    @Test
    public void scPow()
    {
        SciCalc sc = new SciCalc();
        BigInteger result = sc.pow(100, 4);
        int comparison = BigInteger.valueOf(100000000).compareTo(result);
        assertEquals(comparison, 0);
    }
    @Test
    public void scAdd()
    {
        SciCalc sc = new SciCalc();
        long result = sc.add(432, -432);
        assertEquals(0, result);
    }

    // FinCalc
    @Test
    public void fcMLP() {
        var fc = new FinCalc();
        // 500K loan at 3.5% (0.035) annual rate for 30 years
        double M = fc.monthlyLoanPayment(500_000, 0.035, 30);
        assertEquals(2245.22, M, 0.01);
    }

    @Test
    public void fcMulFractions() {
        var fc = new FinCalc();
        Fraction f1 = new Fraction(3, 8);
        Fraction f2 = new Fraction(2, 6);
        Fraction results = fc.mulFractions(f1, f2);

        Assertions.assertAll(
                () -> assertEquals(1, results.get_numerator()),
                () -> assertEquals(8, results.get_denominator())
        );
    }

    @Test
    public void fcPow() {
        var fc = new FinCalc();
        BigInteger bignum = fc.pow(4, 40);
        assertEquals("1208925819614629174706176", bignum.toString());
    }
}
