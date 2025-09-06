import java.util.Scanner;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger("ShiftStringLogger");

    // Constants
    private static final int MAX_STRING_LENGTH = 1000;
    private static final int MIN_SHIFT = -1000;
    private static final int MAX_SHIFT = 1000;

    /**
     * Main method to start the application.
     * @param args command line arguments
     */
    public static void main(String[] args) throws Exception {
        logInfo("Application started");

        try {
            runApp();
        } catch (Exception e) {
            logError("An unexpected error occurred", e);
            printMessage("An unexpected error occurred. Please try again.");
            e.printStackTrace();
        }

        logInfo("Application ended");
    }

    /**
     * Runs the main application loop.
     * Handles user input, validation, string shifting, and continuation prompts.
     */
    private static void runApp() {
        printWelcomeMessage();

        Scanner scanner = new Scanner(System.in);

        boolean keepGoing = true;
        while (keepGoing) {
            // Input reading
            String inputString = getValidatedStringInput(scanner);

            // Read shift positions
            int shiftPositions = getValidatedShiftInput(scanner);

            // Perform the shift
            String result = shiftString(inputString, shiftPositions);
            logInfo(result + " is the shifted string.");
            printMessage("\nShifted String: \"" + result + "\"");

            // Ask if they want to go again
            keepGoing = askToContinue(scanner);
        }

        System.out.println("Goodbye! Thank you :)");
        scanner.close();
    }

    /**
     * Asks the user if they want to continue and validates the input.
     * @param scanner the Scanner object for reading input
     * @return true if the user wants to continue, false otherwise
     */
    private static boolean askToContinue(Scanner scanner) {
        while (true) {
            printMessage("\nDo you want to go again? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            switch (answer) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    printMessage("Invalid input. Please enter 'y' for yes or 'n' for no.");
                    logWarning(answer + " is not a valid input for continuation prompt.");
                    continue;
            }
        }
    }

    /**
     * Prompts the user for a valid integer input and validates it.
     * @param scanner the Scanner object for reading input
     * @return a validated integer
     */
    private static int getValidatedShiftInput(Scanner scanner) {
        printMessage("\nEnter a number between -1000 and 1000 to shift your string by");
        printMessage("(negative = left shift, positive = right shift):");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                logWarning("Empty input for shift positions.");
                printMessage("Please enter a valid integer for shift positions in range (-1000, 1000).");
                continue;
            }
            try {
                int shiftPositions = Integer.parseInt(line);
                return validateInt(shiftPositions);
            } catch (NumberFormatException e) {
                logWarning(line + " is not a valid integer input for shift positions.");
                printMessage("Please enter a valid integer for shift positions in range (-1000, 1000).");
            } catch (IllegalArgumentException e) {
                logWarning("Illegal argument in getValidationShiftInput() " + e.getMessage());
                printMessage(e.getMessage());
            }
        }
    }

    /**
     * Prompts the user for a valid string input and validates it.
     * @param scanner the Scanner object for reading input
     * @return a validated string
     */
    private static String getValidatedStringInput(Scanner scanner) {
        while (true) {
            printMessage("\nPlease enter a string with maximum 1000 characters including whitespaces: ");
            var inputString = scanner.nextLine();
            try {
                return validateString(inputString);
            } catch (IllegalArgumentException e) {
                logWarning("Illegal argument in getValidationStringInput() " + e.getMessage());
                printMessage(e.getMessage());
            }
        }
    }

    /**
     * Validates the shift positions.
     * @param shiftPositions the number of positions to validate
     * @throws IllegalArgumentException if the input is invalid
     */
    private static int validateInt(int shiftPositions) {
        // Input validation for shift positions
        if (shiftPositions < MIN_SHIFT || shiftPositions > MAX_SHIFT) {
            logError("Illegal argument in validateInt", new IllegalArgumentException("Shift positions must be between -1000 and 1000"));
            throw new IllegalArgumentException("Shift positions must be between -1000 and 1000");
        } 
        return shiftPositions;
    }

    /**
     * Validates the input string.
     * @param inputString the string to validate
     * @throws IllegalArgumentException if the input is invalid
     */
    private static String validateString(String inputString) {
        // Input validation
        if (inputString == null || inputString.isEmpty()) {
            logError(inputString, new IllegalArgumentException("Input string cannot be null or empty"));
            throw new IllegalArgumentException("Input string cannot be null or empty");
        } else if (!inputString.matches("[a-zA-Z\\s]+")) {
            logError(inputString, new IllegalArgumentException("Input string must contain only alphabetic letters (a-z, A-Z) and spaces"));
            throw new IllegalArgumentException("Input string must contain only alphabetic letters (a-z, A-Z) and spaces");
        } else if (inputString.length() > MAX_STRING_LENGTH) {
            logError(inputString, new IllegalArgumentException("Input string must not exceed 1000 characters"));
            throw new IllegalArgumentException("Input string must not exceed 1000 characters");
        }
        return inputString;
    }

    /**
     * Shifts the string by the specified number of positions.
     * @param str the string to shift
     * @param shift the number of positions to shift
     * @return the shifted string
     */
    public static String shiftString(String str, int shift) {
        // Return the string as is if no shift is needed
        if (str == null || str.isEmpty() || shift == 0) {
            logInfo(str + " requires no shifting.");
            return str;
        }

        // Normalize shift to be within the length of the string
        int len = str.length();
        shift = shift % len;

        if (shift < 0) {    // Left shift
            int leftShift = -shift;
            logInfo(str + " will be left shifted by " + leftShift + " positions.");
            return str.substring(leftShift) + str.substring(0, leftShift);
        } else {  // Right shift
            logInfo(str + " will be right shifted by " + shift + " positions.");
            return str.substring(len - shift) + str.substring(0, len - shift);
        }
    }

    
    // Print methods
    private static void printWelcomeMessage() {
        printMessage("Welcome to the String Shifter!");
        printMessage("You can shift characters in a string by a specified number of positions.");
    }
    private static void printMessage(String message) {
        System.out.println(message);
    }

    // Logging methods
    private static void logInfo(String message) {
        logger.info(message);
    }
    private static void logWarning(String message) {
        logger.warning(message);
    }
    private static void logError(String message, Exception e) {
        logger.severe(message + " | Exception: " + e.getMessage());
    }
}
