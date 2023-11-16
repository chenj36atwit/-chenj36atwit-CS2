package wit.comp1050;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> hand = new ArrayList<Card>();

    public void add(Card card) {
        hand.add(card);
    }

    public void print() {

        String s = "";

        for (Card c : hand) {
            s = s + c.toString() + "\n";
        }

        System.out.println(s);
    }

    public void sort() {

        Collections.sort(hand);

    }

    public int sum() {
        int sum = 0;

        for (Card c : hand) {
            sum = sum + c.getValue();
        }

        return sum;

    }

    public int compareTo(Hand hand) {

        if (sum() == hand.sum()) {
            return 0;
        } else if (sum() > hand.sum()) {
            return 1;
        } else {
            return -1;
        }

    }

    public void sortAgainstSuit(){

        Collections.sort(hand, new Suit());

    }

}
