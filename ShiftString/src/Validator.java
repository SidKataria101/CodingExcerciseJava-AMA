import java.util.Scanner;
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
    private static final String SHIFT_RANGE_MESSAGE = "Shift positions must be between " + MIN_SHIFT + " and " + MAX_SHIFT;
    private static final String EMPTY_STRING_ERROR = "Input string cannot be null or empty";
    private static final String EXCEEDS_MAX_STRING_LENGTH_ERROR = "Input string must not exceed " + MAX_STRING_LENGTH + " characters";
    private static final String INVALID_STRING_PATTERN_ERROR = "Input string must contain only alphabetic letters (a-z, A-Z) and spaces";

    /**
     * Prompts the user for a valid integer input and validates it.
     * @param scanner the Scanner object for reading input
     * @return a validated integer
     */
    static int getValidatedShiftInput(Scanner scanner) {
        Console.printMessage("\nEnter a number between -1000 and 1000 to shift your string by");
        Console.printMessage("(negative = left shift, positive = right shift):");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                Console.logWarning("Empty input for shift positions.");
                Console.printError("Please enter a valid integer for shift positions in range (-1000, 1000).");
                continue;
            }
            try {
                int shiftPositions = Integer.parseInt(line);
                return Validator.validateInt(shiftPositions);
            } catch (NumberFormatException e) {
                Console.logWarning(line + " is not a valid integer input for shift positions.");
                Console.printError("Please enter a valid integer for shift positions in range (-1000, 1000).");
            } catch (IllegalArgumentException e) {
                Console.logWarning("Illegal argument in getValidationShiftInput() " + e.getMessage());
                Console.printError(e.getMessage());
            }
        }
    }

    /**
     * Prompts the user for a valid string input and validates it.
     * @param scanner the Scanner object for reading input
     * @return a validated string
     */
    static String getValidatedStringInput(Scanner scanner) {
        while (true) {
            Console.printMessage("\nPlease enter a string with maximum 1000 characters including whitespaces: ");
            var inputString = scanner.nextLine();
            try {
                return Validator.validateString(inputString);
            } catch (IllegalArgumentException e) {
                Console.logWarning("Illegal argument in getValidationStringInput() " + e.getMessage());
                Console.printError(e.getMessage());
            }
        }
    }

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
            throw new IllegalArgumentException(EMPTY_STRING_ERROR);
        } else if (!VALID_STRING_PATTERN.matcher(inputString).matches()) {
            throw new IllegalArgumentException(INVALID_STRING_PATTERN_ERROR);
        } else if (inputString.length() > MAX_STRING_LENGTH) {
            throw new IllegalArgumentException(EXCEEDS_MAX_STRING_LENGTH_ERROR);
        }
        return inputString;
    }

    /**
     * Asks the user if they want to continue and validates the input.
     * @param scanner the Scanner object for reading input
     * @return true if the user wants to continue, false otherwise
     */
    static boolean askToContinue(Scanner scanner) {
        while (true) {
            Console.printMessage("\nDo you want to go again? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            switch (answer) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    Console.printMessage("Invalid input. Please enter 'y' for yes or 'n' for no.");
                    Console.logWarning(answer + " is not a valid input for continuation prompt.");
                    continue;
            }
        }
    }
}
