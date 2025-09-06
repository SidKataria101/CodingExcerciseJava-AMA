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
                keepGoing = Validator.askToContinue(scanner);
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
}
