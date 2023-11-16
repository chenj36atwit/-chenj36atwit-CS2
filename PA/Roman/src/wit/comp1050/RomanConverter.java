package wit.comp1050;

import java.util.Scanner;

public class RomanConverter {

    public static void main(String[] args){
        int[] numbers = new int[] {1000, 500, 100, 50, 10, 5, 1};
        final int MAX = 3999;

        System.out.print("Enter a roman numeral: ");
        Scanner keyb = new Scanner(System.in);
        String roman = keyb.next();
        keyb.close();

        roman = roman.toUpperCase();

        long AN = roman2Arabic(roman);
        String HN = asHex(AN);
        String BN = asBinary(AN);

        System.out.println("Your Roman Numeral to Arabic is: "+AN);
        System.out.println("Your Roman Numeral to Hex is: "+HN);
        System.out.println("Your Roman Numeral to Binary is: "+BN);

        if (roman.matches("[0-9]") || !roman.matches("[M|D|C|L|X|V|I]")) {
            System.out.println("Roman Numeral doesn't work!");
        }
    }

    public static long roman2Arabic (String roman) {
        int i = 0;
        int current = 0;
        int previous = 0;
        int arabic = 0;

        while (i < roman.length()) {

            char letter = roman.charAt(i);

            switch (letter) {
                case ('I'):
                    current = 1;
                    break;
                case ('V'):
                    current = 5;
                    break;
                case ('X'):
                    current = 10;
                    break;
                case ('L'):
                    current = 50;
                    break;
                case ('C'):
                    current = 100;
                    break;
                case ('D'):
                    current = 500;
                    break;
                case ('M'):
                    current = 1000;
                    break;
            }

            if (current > previous) {

                arabic += current - (previous * 2);

            }
            else {

                arabic += current;

            }

            previous = current;

            i += 1;

        }
        return arabic;
    }

    public static String asHex (long val){

        return Long.toHexString(val);

    }

    public static String asBinary (long val){

        return Long.toBinaryString(val);

    }
}

