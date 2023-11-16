package wit.comp1050;


import java.util.Scanner;

public class MainApp
{

    private static Scanner sc = new Scanner(System.in);

    private static String a;

    public static void main(String[] args) throws Exception
    {

        System.out.println("Welcome to File!");
        System.out.println("1. PlainText ");
        System.out.println("2. Encryption/Decryption your PlainText ");
        System.out.println("3. Read All Files ");
        System.out.println("4. Exit the Program ");
        int x = sc.nextInt();

        if(x == 1) {

            System.out.println("Type something in: ");

            a = sc.next();

            new PlainTextFile().write(a);

            System.out.println("Do you want to append? ");
            String v = sc.next();

            if(v.equalsIgnoreCase("y")) {

                System.out.println("Type: ");
                String b = sc.next();

                new PlainTextFile().append(b);

                main(null);
            }

            else if(v.equalsIgnoreCase("n")) {

                main(null);

            }
            else {

                System.out.println("Error!");
                System.exit(0);

            }

        }
        else if(x == 2) {

            new EncryptedTextFile().start();
            main(null);

        }
        else if(x == 3) {

            new PlainTextFile().readAll();
            new EncryptedTextFile().readAll();
            main(null);

        }
        else if(x == 4) {

            System.exit(0);

        }
        else {

            System.out.println("Error");

        }

    }

}
