import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

/**
 * Test class for Validator.
 */
public class ValidatorTest {

    @Test
    void validateInt_validRange() {
        // Test valid range values including boundaries
        assertEquals(0, Validator.validateInt(0));
        assertEquals(1000, Validator.validateInt(1000));
        assertEquals(-1000, Validator.validateInt(-1000));
        assertEquals(500, Validator.validateInt(500));
    }

    @Test
    void validateInt_outOfRange() {
        // Test invalid range values
        assertThrows(IllegalArgumentException.class, () -> Validator.validateInt(1001));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateInt(-1001));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateInt(2000));
    }

    @Test
    void validateString_validInput() {
        // Test valid string inputs
        assertEquals("hello world", Validator.validateString("hello world"));
        assertEquals("ama", Validator.validateString("ama"));
        assertEquals("Hello World", Validator.validateString("Hello World"));
        assertEquals("   ", Validator.validateString("   ")); // Only spaces
    }

    @Test
    void validateString_invalidInput() {
        // Test invalid string inputs
        assertThrows(IllegalArgumentException.class, () -> Validator.validateString(""));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateString(null));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateString("hello123"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateString("hello!"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateString("a".repeat(1001)));
    }

    @Test
    void askToContinue_validInput() {
        // Test valid continue responses
        String input = "y\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        assertTrue(Validator.askToContinue(scanner));
        
        input = "n\n";
        scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        assertFalse(Validator.askToContinue(scanner));
    }

    @Test
    void askToContinue_invalidInput() {
        // Test invalid continue responses - the method loops until valid input, so we need to provide both invalid and valid input
        String input = "invalid\nmaybe\nn\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        assertFalse(Validator.askToContinue(scanner));
    }
}
