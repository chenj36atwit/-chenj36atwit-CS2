package wit.comp1050;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanConverterTest {

    @Test
    void roman2ArabicI()
    {
        long arabic = RomanConverter.roman2Arabic("I");
        assertEquals(1, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("1", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("1", s);
    }

    @Test
    void roman2ArabicV()
    {
        long arabic = RomanConverter.roman2Arabic("V");
        assertEquals(5, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("5", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("101", s);
    }

    @Test
    void roman2ArabicX()
    {
        long arabic = RomanConverter.roman2Arabic("X");
        assertEquals(10, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("a", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("1010", s);
    }

    @Test
    void roman2ArabicL()
    {
        long arabic = RomanConverter.roman2Arabic("L");
        assertEquals(50, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("32", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("110010", s);
    }

    @Test
    void roman2ArabicC()
    {
        long arabic = RomanConverter.roman2Arabic("C");
        assertEquals(100, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("64", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("1100100", s);
    }

    @Test
    void roman2ArabicD()
    {
        long arabic = RomanConverter.roman2Arabic("D");
        assertEquals(500, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("1f4", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("111110100", s);
    }

    @Test
    void roman2ArabicLM()
    {
        long arabic = RomanConverter.roman2Arabic("M");
        assertEquals(1000, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("3e8", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("1111101000", s);
    }
    @Test
    void roman2ArabicVII()
    {
        long arabic = RomanConverter.roman2Arabic("VII");
        assertEquals(7, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("7", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("111", s);
    }

    @Test
    void roman2ArabicIX()
    {
        long arabic = RomanConverter.roman2Arabic("IX");
        assertEquals(9, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("9", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("1001", s);
    }

    @Test
    void roman2ArabicMCL()
    {
        long arabic = RomanConverter.roman2Arabic("MCL");
        assertEquals(1150, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("47e", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("10001111110", s);
    }

    @Test
    void roman2ArabicMMXXI()
    {
        long arabic = RomanConverter.roman2Arabic("MMXXI");
        assertEquals(2021, arabic);
        String s = RomanConverter.asHex(arabic);
        assertEquals("7e5", s);
        s = RomanConverter.asBinary(arabic);
        assertEquals("11111100101", s);
    }

}
