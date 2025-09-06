import java.util.Scanner;

/**
 * Main application class to run the ShiftString program.
 */
public class App {

    /**
     * Main method to start the application.
     * @param args command line arguments
     */
    public static void main(String[] args) throws Exception {
        Console.logInfo("Application started");

        try {
            runApp();
        } catch (Exception e) {
            Console.logError("An unexpected error occurred", e);
            Console.printError("An unexpected error occurred. Please try again.");
        }

        Console.logInfo("Application ended");
    }

    /**
     * Runs the main application loop.
     * Handles user input, validation, string shifting, and continuation prompts.
     */
    private static void runApp() {
        Console.printWelcomeMessage();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepGoing = true;
            while (keepGoing) {
                processSingleShift(scanner);
                keepGoing = askToContinue(scanner);
            }
        }

        Console.printMessage("Goodbye! Thank you :)");
    }

    /**
     * Processes a single string shift operation.
     * @param scanner the Scanner object for reading input
     */
    private static void processSingleShift(Scanner scanner) {
        // Input string
        String inputString = Validator.getValidatedStringInput(scanner);

        // Input shift
        int shiftPositions = Validator.getValidatedShiftInput(scanner);

        // Perform shift
        String result = Shifter.shiftString(inputString, shiftPositions);

        Console.logInfo("Shift completed (input length=" + inputString.length() + 
                ", shift=" + shiftPositions + 
                ", result length=" + result.length() + ")");
        Console.printMessage("\nShifted String: \"" + result + "\"");
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
