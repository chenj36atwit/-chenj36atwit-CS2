package wit.comp1050;

import java.util.*;

public class Main {

     public static void main(String[] args) {


         Card first = new Card(2, Card.DIAMOND);
         Card second = new Card(14, Card.CLUB);
         Card third = new Card(12, Card.HEART);
         Card fourth = new Card(14, Card.HEART);

         System.out.println(first);
         System.out.println(second);
         System.out.println(third);
         System.out.println(fourth);

         System.out.println("");

         List <Card> Cards = new ArrayList<Card>();

         Cards.add(first);
         Cards.add(second);
         Cards.add(third);
         Cards.add(fourth);

         System.out.println(Cards);
         Collections.sort(Cards);
         System.out.println(Cards);
         Collections.reverse(Cards);
         System.out.println(Cards);

         Hand hand = new Hand();

         hand.add(new Card(2, Card.SPADE));
         hand.add(new Card(14, Card.CLUB));
         hand.add(new Card(12, Card.HEART));
         hand.add(new Card(2, Card.CLUB));

         hand.print();

         hand.sort();
         hand.print();

         Hand hand1 = new Hand();

         hand1.add(new Card(2, Card.SPADE));
         hand1.add(new Card(14, Card.CLUB));
         hand1.add(new Card(12, Card.HEART));
         hand1.add(new Card(2, Card.CLUB));

         Hand hand2 = new Hand();

         hand2.add(new Card(11, Card.DIAMOND));
         hand2.add(new Card(11, Card.CLUB));
         hand2.add(new Card(11, Card.HEART));

         int comparison = hand1.compareTo(hand2);

         if (comparison < 0) {
         System.out.println("most valuable hand contains the cards");
         hand2.print();
         } else if (comparison > 0) {
         System.out.println("the valuable hand contains the cards");
         hand1.print();
         } else {
         System.out.println("the hands are equally valuable");
         }

         ArrayList<Card> theCards = new ArrayList<Card>();

         theCards.add(new Card(3, Card.CLUB));
         theCards.add(new Card(2, Card.DIAMOND));
         theCards.add(new Card(14, Card.CLUB));
         theCards.add(new Card(12, Card.HEART));
         theCards.add(new Card(2, Card.CLUB));

         Collections.sort(theCards, new Suit());
         Collections.reverse(theCards);
         System.out.println(theCards);

         for (Card c : theCards) {
         System.out.println(c);
         }

        Hand h = new Hand();

        h.add(new Card(12, Card.HEART));
        h.add(new Card(4, Card.CLUB));
        h.add(new Card(2, Card.DIAMOND));
        h.add(new Card(14, Card.CLUB));
        h.add(new Card(7, Card.HEART));
        h.add(new Card(2, Card.CLUB));

        h.sortAgainstSuit();

        h.print();

    }

}

