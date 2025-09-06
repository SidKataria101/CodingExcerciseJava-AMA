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
    private static final String EMPTY_STRING_ERROR = "Input string cannot be null or empty";
    private static final String EXCEEDS_MAX_STRING_LENGTH_ERROR = "Input string must not exceed " + MAX_STRING_LENGTH + " characters";
    private static final String INVALID_STRING_PATTERN_ERROR = "Input string must contain only alphabetic letters (a-z, A-Z) and spaces";

    /**
     * Validates the shift positions.
     * @param shiftPositions the number of positions to validate
     * @throws IllegalArgumentException if the input is invalid
     */
    static int validateInt(int shiftPositions) {
        // Input validation for shift positions
        if (shiftPositions < MIN_SHIFT || shiftPositions > MAX_SHIFT) {
            Console.printError("Illegal argument in validateInt\n" + SHIFT_RANGE_MESSAGE);
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
            //Console.logError(inputString, new IllegalArgumentException(EMPTY_STRING_ERROR));
            //Console.printError(EMPTY_STRING_ERROR);
            throw new IllegalArgumentException(EMPTY_STRING_ERROR);
        } else if (!VALID_STRING_PATTERN.matcher(inputString).matches()) {
            //Console.logError(inputString, new IllegalArgumentException(INVALID_STRING_PATTERN_ERROR));
            //Console.printError(inputString + " " + INVALID_STRING_PATTERN_ERROR);
            throw new IllegalArgumentException(INVALID_STRING_PATTERN_ERROR);
        } else if (inputString.length() > MAX_STRING_LENGTH) {
            //Console.logError(inputString, new IllegalArgumentException(EXCEEDS_MAX_STRING_LENGTH_ERROR));
            //Console.printError(EXCEEDS_MAX_STRING_LENGTH_ERROR);
            throw new IllegalArgumentException(EXCEEDS_MAX_STRING_LENGTH_ERROR);
        }
        return inputString;
    }



}
