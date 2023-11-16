package wit.comp1050;

//By Jacky Chen on 1/20/2022

import java.util.Random;
import java.util.Scanner;

public class StreetCraps {

    private static int firstnumber;

    private static int countnumber;

    private static int Bank;

    private static int bet;

    private static String N;

    public static void main(String[] args) {

       CheckIN();

    }
    public static void CheckIN(){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a Username: ");
        N = input.nextLine();

        System.out.print("Enter your Bankroll amount: ");
        Bank = input.nextInt();

        Checker(N,Bank);

    }
    public static void Checker(String Name, int B){

        if(Name == "" || B < 1){

            System.out.println("Either your name is blank or Bankroll has insufficient amount.");
            System.out.println("Please Try Again!");
            CheckIN();

        }
        else{

            GameStart(Name, B);

        }

    }
    public static void Intro(String Name, int B){

        System.out.println("Welcome to GiveMe Your Money Casio, "+Name+" Good Luck with your Money!");
        GameStart(N, Bank);

    }
    public static void GameStart(String Name, int B){

        Scanner sc = new Scanner(System.in);

        System.out.print(Name+ ", you have $"+Bank+ ". How much will you want to bet? ");
        bet = sc.nextInt();
        System.out.println(Name+ ", you have enter: "+bet);
        Bank = Bank - bet;

        while(true){

            if(bet <= 0){

                System.out.println("You cashed out with $"+Bank);
                System.exit(0);
            }
            else{

                System.out.println("Enter v to start rolling!");
                String z = sc.nextLine();

                if(z.equalsIgnoreCase("v")){

                    Game1();

                }
            }

        }

    }
    public static void Game1(){

        Random rand = new Random();

        int a = rand.nextInt((6 - 1) + 1) + 1;
        int b = rand.nextInt((6 - 1) + 1) + 1;

        firstnumber = a+b;

        System.out.println("You Rolled "+a+ ","+b+" = "+firstnumber);
        Win1Lose1(firstnumber);

    }

    public static void Win1Lose1(int x1){

        if(firstnumber == 7 || firstnumber == 11){

            System.out.println("You Win!");
            Bank = Bank + bet + bet;
            GameStart(N, Bank);

        }
        else if(firstnumber == 2 || firstnumber == 3 || firstnumber == 12){

            System.out.println("You lose");
            if(Bank == 0){

                System.out.println("You have not more money! Better next time Loser!");
                System.exit(0);

            }
            else{

                GameStart(N, Bank);

            }

        }
        else{

            Game2();

        }

    }
    public static void Game2(){

        Scanner sc2 = new Scanner(System.in);

        Random rand = new Random();

        System.out.println("Hit v to start rolling again!");

        String zz = sc2.nextLine();

        if(zz.equals("v") || zz.equals("V")){

            int a = rand.nextInt((6 - 1) + 1) + 1;
            int b = rand.nextInt((6 - 1) + 1) + 1;

            countnumber = a+b;

            System.out.println("You Rolled "+a+ ","+b+" = "+countnumber);
            Win2Lose2(countnumber);

        }

    }
    public static void Win2Lose2(int x2){

        if(countnumber == firstnumber){

            System.out.println("You Win!");
            Bank = Bank + bet + bet;
            GameStart(N, Bank);

        }
        else if(countnumber == 7){

            System.out.println("You lose");
            if(Bank == 0){

                System.out.println("You have not more money! Better next time Loser!");
                System.exit(0);
            }

            else{

                GameStart(N, Bank);
                
            }

        }
        else{

            Game2();

        }

    }



}
