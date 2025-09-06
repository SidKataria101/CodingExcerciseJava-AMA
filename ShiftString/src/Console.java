import java.util.logging.Logger;

/**
 * ConsoleUI class to handle all console interactions and logging.
 */
public class Console {
        
    private static final Logger logger = Logger.getLogger("ShiftStringLogger");

    // ANSI color codes for console output
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    // Print methods
    static void printWelcomeMessage() {
        printMessage("Welcome to the String Shifter!");
        printMessage("You can shift characters in a string by a specified number of positions.");
    }
    static void printMessage(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }
    static void printError(String error) {
        System.out.println(ANSI_RED + error + ANSI_RESET);
    }

    // Logging methods
    static void logInfo(String message) {
        logger.info(message);
    }
    static void logWarning(String message) {
        logger.warning(message);
    }
    static void logError(String message, Exception e) {
        logger.severe(message + " | Exception: " + e.getMessage());
    }

}
