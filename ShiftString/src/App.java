import java.util.Scanner;

public class App {

    /**
     * Main method to start the application.
     * @param args command line arguments
     */
    public static void main(String[] args) throws Exception {
        ConsoleUI.logInfo("Application started");

        try {
            runApp();
        } catch (Exception e) {
            ConsoleUI.logError("An unexpected error occurred", e);
            ConsoleUI.printMessage("An unexpected error occurred. Please try again.");
        }

        ConsoleUI.logInfo("Application ended");
    }

    /**
     * Runs the main application loop.
     * Handles user input, validation, string shifting, and continuation prompts.
     */
    private static void runApp() {
        ConsoleUI.printWelcomeMessage();

        // Use try-with-resources so Scanner is closed cleanly
        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepGoing = true;
            while (keepGoing) {
                processSingleShift(scanner);
                keepGoing = ConsoleUI.askToContinue(scanner);
            }
        }

        ConsoleUI.printMessage("Goodbye! Thank you :)");
    }

    /**
     * Processes a single string shift operation.
     * @param scanner the Scanner object for reading input
     */
    private static void processSingleShift(Scanner scanner) {
        // Input string
        String inputString = ConsoleUI.getValidatedStringInput(scanner);

        // Input shift
        int shiftPositions = ConsoleUI.getValidatedShiftInput(scanner);

        // Perform shift
        String result = Shifter.shiftString(inputString, shiftPositions);

        ConsoleUI.logInfo("Shift completed (input length=" + inputString.length() + 
                ", shift=" + shiftPositions + 
                ", result length=" + result.length() + ")");
        ConsoleUI.printMessage("\nShifted String: \"" + result + "\"");
    }
}
