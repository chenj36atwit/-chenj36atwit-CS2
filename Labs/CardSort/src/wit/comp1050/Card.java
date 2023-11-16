package wit.comp1050;

public class Card implements Comparable<Card>{

    public static final int SPADE  = 0;
    public static final int DIAMOND  = 1;
    public static final int HEART = 2;
    public static final int CLUB   = 3;

    private int value;
    private int suit;

    public Card(int value, Integer suit){
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
            s = "Spades";
        }

        if(this.suit==1){
            s = "Diamonds";
        }

        if(this.suit==2){
            s = "Hearts";
        }

        if(this.suit==3){
            s = "Clubs";
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

}

