package wit.comp1050;

public class FinCalc extends SciCalc {

    public double monthlyLoanPayment(double P, double r, double n) {

        double m= (P * r) / (1 - Math.pow(1 + r, -n));

        return m;

    }

    public Fraction addFractions(Fraction f1, Fraction f2) {

        Fraction frac = Fraction.add(f1,f2);
        return frac.reduce();

    }
    public Fraction subFractions(Fraction f1, Fraction f2) {

        Fraction frac = Fraction.sub(f1,f2);
        return frac.reduce();

    }
    public Fraction mulFractions(Fraction f1, Fraction f2) {

        Fraction frac = Fraction.mul(f1,f2);
        return frac.reduce();

    }
    public Fraction divFractions(Fraction f1, Fraction f2) {

        Fraction frac = Fraction.div(f1,f2);
        return frac.reduce();

    }

// Note that all Fractions are returned in reduced form.



}













