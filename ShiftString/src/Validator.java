import java.util.regex.Pattern;

/**
 * Validator class to handle input validations.
 */
public class Validator {
    
    // Constants
    private static final int MAX_STRING_LENGTH = 1000;
    private static final int MIN_SHIFT = -1000;
    private static final int MAX_SHIFT = 1000;
    private static final Pattern VALID_STRING_PATTERN = Pattern.compile("[a-zA-Z\\s]+");
    public static final String SHIFT_RANGE_MESSAGE = "Shift positions must be between " + MIN_SHIFT + " and " + MAX_SHIFT;

    /**
     * Validates the shift positions.
     * @param shiftPositions the number of positions to validate
     * @throws IllegalArgumentException if the input is invalid
     */
    static int validateInt(int shiftPositions) {
        // Input validation for shift positions
        if (shiftPositions < MIN_SHIFT || shiftPositions > MAX_SHIFT) {
            throw new IllegalArgumentException("Shift positions must be between -1000 and 1000");
        } 
        return shiftPositions;
    }

    /**
     * Validates the input string.
     * @param inputString the string to validate
     * @throws IllegalArgumentException if the input is invalid
     */
    static String validateString(String inputString) {
        // Input validation
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        } else if (!VALID_STRING_PATTERN.matcher(inputString).matches()) {
            throw new IllegalArgumentException("Input string must contain only alphabetic letters (a-z, A-Z) and spaces");
        } else if (inputString.length() > MAX_STRING_LENGTH) {
            throw new IllegalArgumentException("Input string must not exceed 1000 characters");
        }
        return inputString;
    }



}
