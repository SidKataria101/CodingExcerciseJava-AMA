import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleUI {
        
    private static final Logger logger = Logger.getLogger("ShiftStringLogger");

    /**
     * Asks the user if they want to continue and validates the input.
     * @param scanner the Scanner object for reading input
     * @return true if the user wants to continue, false otherwise
     */
    static boolean askToContinue(Scanner scanner) {
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
    static int getValidatedShiftInput(Scanner scanner) {
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
                return Validator.validateInt(shiftPositions);
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
    static String getValidatedStringInput(Scanner scanner) {
        while (true) {
            printMessage("\nPlease enter a string with maximum 1000 characters including whitespaces: ");
            var inputString = scanner.nextLine();
            try {
                return Validator.validateString(inputString);
            } catch (IllegalArgumentException e) {
                logWarning("Illegal argument in getValidationStringInput() " + e.getMessage());
                printMessage(e.getMessage());
            }
        }
    }


    // Print methods
    static void printWelcomeMessage() {
        printMessage("Welcome to the String Shifter!");
        printMessage("You can shift characters in a string by a specified number of positions.");
    }
    static void printMessage(String message) {
        System.out.println(message);
    }

    // Logging methods
    static void logInfo(String message) {
        logger.info(message);
    }
    private static void logWarning(String message) {
        logger.warning(message);
    }
    static void logError(String message, Exception e) {
        logger.severe(message + " | Exception: " + e.getMessage());
    }

}
