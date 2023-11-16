package wit.comp1050;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    private static Fraction f1;
    private static Fraction f2;

    public static void main(String[] args) {

        try {

            System.out.println("Welcome! Choose the Calculators you want to use: ");

            System.out.println("1. Basic ");
            System.out.println("2. Sci ");
            System.out.println("3. Fin ");
            System.out.println("4. Exit program ");

            int count = sc.nextInt();

            CalcMain(count);

        } catch (Exception ex) {

            System.out.println("Invalid Input");

        }

    }
    public static void CalcMain(int count) {

        if(count == 1) {

            BasicCalc B = new BasicCalc();

            System.out.println("Welcome to Basic Calc!");

            System.out.println("Choose a number for a: ");
            int a = sc.nextInt();
            System.out.println("Choose a number for b: ");
            int b = sc.nextInt();

            System.out.println("Choose which math operation you want to do: ");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Times");
            System.out.println("4. Divide");
            System.out.println("5. Return to Main");
            int basiccount = sc.nextInt();

            if (basiccount == 1) {

                long result = B.add(a,b);
                System.out.println("Your add result: "+result);
                System.out.println();
                main(null);


            } else if (basiccount == 2) {

                long result = B.sub(a,b);
                System.out.println("Your sub result: "+result);
                System.out.println();
                main(null);

            } else if (basiccount == 3) {

                BigInteger result = B.mul(a,b);
                System.out.println("Your mul result: "+result);
                System.out.println();
                main(null);

            } else if (basiccount == 4) {

                try {
                    if(b <= 0){

                        System.out.println("Integer value divide by zero");

                    }
                    else {

                        BigDecimal result = B.div(a,b);
                        System.out.printf("Your div result: %.3f%n", result);
                        System.out.println();
                        main(null);

                    }

                } catch (ArithmeticException ex) {

                    ex.printStackTrace();

                }

            } else if(basiccount == 5){

                main(null);

            } else{

                System.out.println("Invalid Input");

            }

        }

        else if (count == 2) {

            SciCalc m = new SciCalc();

            System.out.println("Welcome to Sci Calc!");
            System.out.println("Choose which math operation you want to do: ");
            System.out.println("1. Square ");
            System.out.println("2. Find the power ");
            System.out.println("3. Return to Main Menu");
            int scicount = sc.nextInt();

            if (scicount == 1) {

                System.out.println("Enter number for n: ");
                int n = sc.nextInt();

                int result = m.sqrt(n);

                System.out.println("Your square result: "+result);
                System.out.println();

                main(null);


            } else if (scicount == 2) {

                int a = 0, b = 0;

                System.out.println("Enter number for n: ");
                a = sc.nextInt();
                System.out.println("Enter number for p: ");
                b = sc.nextInt();

                BigInteger result = m.pow(a,b);

                System.out.println("Your power value result: "+result);
                System.out.println();

                main(null);

            } else if (scicount == 3) {

                main(null);

            } else {

                System.out.println("Invalid Input");

            }

        }
        else if (count == 3) {

            FinCalc f = new FinCalc();

            System.out.println("Welcome to Fin Calc!");
            System.out.println("Choose which math operation you want to do: ");
            System.out.println("1. Monthly Loans ");
            System.out.println("2. Fractions ");
            System.out.println("3. Return to Main Menu");
            int fincount = sc.nextInt();

            if(fincount == 1) {

                System.out.print("Enter Principal Amount : ");
                int principal = sc.nextInt();
                System.out.print("Enter Rate of Interest : ");
                float rate = sc.nextFloat();
                rate =(rate/100)/12;
                System.out.print("Enter Time period in years : ");
                int time = sc.nextInt();
                time = time * 12;

                double result = f.monthlyLoanPayment(principal,rate,time);

                System.out.printf("Your Monthly Payment: %.2f%n",result);
                System.out.println();
                main(null);


            } else if(fincount == 2) {

                int n1 = sc.nextInt();
                int d1 = sc.nextInt();

                int n2 = sc.nextInt();
                int d2 = sc.nextInt();

                Fraction f1 = new Fraction(n1,d1);
                Fraction f2 = new Fraction(n2,d2);

                Fraction result1 = f.addFractions(f1,f2);
                Fraction result2 = f.subFractions(f1,f2);
                Fraction result3 = f.mulFractions(f1,f2);
                Fraction result4 = f.divFractions(f1,f2);

                System.out.println("Your add fraction result: "+result1);
                System.out.println();
                System.out.println("Your sub fraction result: "+result2);
                System.out.println();
                System.out.println("Your mul fraction result: "+result3);
                System.out.println();
                System.out.println("Your div fraction result: "+result4);
                System.out.println();
                main(null);


            }  else if(fincount == 3) {

                main(null);

            } else{

                System.out.println("Invalid Input");

            }

        }
        else if (count == 4) {

            System.exit(0);

        }
        else {

            System.out.println("Invalid Input");

        }


    }

}




