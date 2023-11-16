package wit.comp1050;

public class Fraction {


    private int numerator;
    private int denominator;

    //constructor
    public Fraction(int n, int d) {

        numerator = n;
        denominator = d;

        if (d == 0) {

            throw new IllegalArgumentException("Bad denominator!");

        }
        if (n < 0 && d < 0) {

            numerator = -n;
            denominator = -d;

        } else if (n > 0 && d < 0) {

            numerator = -n;
            denominator = -d;

        }
    }


    public int get_numerator() {

        return numerator;

    }

    public int get_denominator() {

        return denominator;

    }

    public Fraction reduce() {

        int GCD;

        if (numerator > denominator) {

            GCD = GCDMath(numerator, denominator);

        } else {

            GCD = GCDMath(denominator, numerator);

        }

        return new Fraction(numerator / GCD, denominator / GCD);
    }

    //fraction add
    public static Fraction add(Fraction f1, Fraction f2) {

        if (f1.get_denominator() != f2.get_denominator()) {

            int nd = f1.get_denominator() * f2.get_denominator();
            int numP1 = f1.get_numerator() * f2.get_denominator();
            int numP2 = f2.get_numerator() * f1.get_denominator();
            int nn = numP1 + numP2;

            return new Fraction(nn, nd);

        }

        return new Fraction(f1.get_numerator() + f2.get_numerator(), f1.get_denominator());
    }

    //fraction subtract
    public static Fraction sub(Fraction f1, Fraction f2) {

        if (f1.get_denominator() != f2.get_denominator()) {

            int nd = f1.get_denominator() * f2.get_denominator();
            int numP1 = f1.get_numerator() * f2.get_denominator();
            int numP2 = f2.get_numerator() * f1.get_denominator();
            int nn = numP1 - numP2;

            if (nn < 0 && nd < 0) {

                nn *= -1;
                nd *= -1;

            }

            return new Fraction(nn, nd);
        }

        return new Fraction(f1.get_numerator() - f2.get_numerator(), f1.get_denominator());
    }

    //fraction times
    public static Fraction mul(Fraction f1, Fraction f2) {

        int newn = f1.get_numerator() * f2.get_numerator();
        int newd = f1.get_denominator() * f2.get_denominator();

        return new Fraction(newn, newd);

    }

    //fraction div
    public static Fraction div(Fraction f1, Fraction f2) {

        Fraction recipricalnum = new Fraction(f2.get_denominator(), f2.get_numerator());

        return Fraction.mul(f1, recipricalnum);

    }

    // find the Greatest Common Divisor with math
    public static int GCDMath(int num1, int num2) {

        int remainder = num1 % num2;

        if (remainder == 0) {

            return num2;

        }

        return Fraction.GCDMath(num2, remainder);

    }

    @Override
    public String toString() {

        return numerator + "/" + denominator;

    }
}