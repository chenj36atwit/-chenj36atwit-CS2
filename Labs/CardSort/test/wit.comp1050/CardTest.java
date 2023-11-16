package wit.comp1050;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CardTest
{
    @Test
    void badCardTest()
    {
        assertAll(
                // Card face value must be between 1-13 and suit cannot be null
                () -> assertThrows(IllegalArgumentException.class, () -> new Card(0, Suit.CLUB)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Card(14, Suit.SPADE)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Card(10, null)));
    }


    @Test
    void cardsEqualTest()
    {
        Card a = new Card(5, Suit.DIAMOND);
        Card b = new Card(5, Suit.DIAMOND);
        int x = a.compareTo(b);
        assertEquals(0, x);
    }

    @Test
    void cardsLeftFaceValueGreaterTest()
    {
        Card a = new Card(13, Suit.DIAMOND);
        Card b = new Card(5, Suit.DIAMOND);
        int x = a.compareTo(b);
        assertTrue(x > 0);
    }

    @Test
    void cardsRightFaceValueGreaterTest()
    {
        Card a = new Card(4, Suit.CLUB);
        Card b = new Card(11, Suit.CLUB);
        int x = a.compareTo(b);
        assertTrue(x < 0);
    }

    @Test
    void cardsMultiTest()
    {
        Card a = new Card(4, Suit.DIAMOND);
        Card b = new Card(4, Suit.CLUB);
        int x = a.compareTo(b);
        assertTrue(x > 0);
    }

    @Test
    void sortCardsTest()
    {
        Card[] theCards = new Card[] {
                new Card(13, Suit.DIAMOND),
                new Card(5, Suit.DIAMOND),
                new Card(11, Suit.HEART),
                new Card(11, Suit.CLUB)
        };
        System.out.println(Arrays.toString(theCards));
        Arrays.sort(theCards);
        System.out.println(Arrays.toString(theCards));
    }

    @Test
    void sortCardsReverseTest()
    {
        Card[] theCards = new Card[] {
                new Card(13, Suit.DIAMOND),
                new Card(5, Suit.DIAMOND),
                new Card(11, Suit.HEART),
                new Card(11, Suit.CLUB)
        };
        System.out.println(Arrays.toString(theCards));
        Arrays.sort(theCards, new CardSorterReverse());
        System.out.println(Arrays.toString(theCards));
    }

}
