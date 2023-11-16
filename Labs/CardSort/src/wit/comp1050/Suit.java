package wit.comp1050;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Suit implements Comparator<Card> {

    public static final int SPADE  = 0;
    public static final int DIAMOND  = 1;
    public static final int HEART = 2;
    public static final int CLUB   = 3;

    private int value;
    private int suit;

    public Suit(){
        this.value=value;
        this.suit=suit;
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public String toString(){

        String v =""+this.value;
        String s ="";

        if(this.value>10){
            if(this.value==11){
                v="J";
            }
            if(this.value==12){
                v="Q";
            }
            if(this.value==13){
                v="K";
            }
            if(this.value==14){
                v="A";
            }
        }

        if(this.suit==0){
            s="Spades";
        }

        if(this.suit==1){
            s="Diamonds";
        }

        if(this.suit==2){
            s="Hearts";
        }

        if(this.suit==3){
            s="Clubs";
        }

        return v+" of "+s;

    }

    public int compareTo(Card card){

        if(this.value == card.getValue()){
            if(this.suit==card.getSuit()){
                return 0;
            }else if(this.suit>card.getValue()){
                return 1;
            }else{
                return -1;
            }
        }else if (this.value > card.getValue()){
            return 1;
        }else{
            return -1;
        }


    }

    @Override
    public int compare(Card o1, Card o2) {
        return 0;
    }

    @Override
    public Comparator<Card> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Card> thenComparing(Comparator<? super Card> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Card> thenComparing(Function<? super Card, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Card> thenComparing(Function<? super Card, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Card> thenComparingInt(ToIntFunction<? super Card> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Card> thenComparingLong(ToLongFunction<? super Card> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Card> thenComparingDouble(ToDoubleFunction<? super Card> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}
