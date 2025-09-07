import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Shifter.
 */
public class ShifterTest {
    
    @Test
    void shiftString_validInput() {
        // Test basic string shifting
        assertEquals("cab", Shifter.shiftString("abc", 1));
        assertEquals("bca", Shifter.shiftString("abc", -1));
        assertEquals("abc", Shifter.shiftString("abc", 0));
        assertEquals("efabcd", Shifter.shiftString("abcdef", 2));
    }
    
    @Test
    void shiftString_withSpaces() {
        // Test string shifting with spaces
        assertEquals("worldhello ", Shifter.shiftString("hello world", 5));
        assertEquals("hello world", Shifter.shiftString("hello world", 0));
        assertEquals("fabc de", Shifter.shiftString("abc def", 1));
        assertEquals("bc defa", Shifter.shiftString("abc def", -1));
    }

    @Test
    void shiftString_largeShifts() {
        // Test very large shift values that wrap around
        String testString = "abcdefghijklmnopqrstuvwxyz"; // 26 characters
        
        // Shifts by exact multiples of string length
        assertEquals(testString, Shifter.shiftString(testString, 26));
        assertEquals(testString, Shifter.shiftString(testString, -26));
        assertEquals(testString, Shifter.shiftString(testString, 52));
        assertEquals(testString, Shifter.shiftString(testString, -52));
        assertEquals(testString, Shifter.shiftString(testString, 78));
        assertEquals(testString, Shifter.shiftString(testString, -78));
        
        // Shifts by string length + small amounts
        assertEquals("zabcdefghijklmnopqrstuvwxy", Shifter.shiftString(testString, 27));
        assertEquals("yzabcdefghijklmnopqrstuvwx", Shifter.shiftString(testString, 28));
        assertEquals("xyzabcdefghijklmnopqrstuvw", Shifter.shiftString(testString, 29));
        assertEquals("bcdefghijklmnopqrstuvwxyza", Shifter.shiftString(testString, -27));
        assertEquals("cdefghijklmnopqrstuvwxyzab", Shifter.shiftString(testString, -28));
        assertEquals("defghijklmnopqrstuvwxyzabc", Shifter.shiftString(testString, -29));
    }

    
}
