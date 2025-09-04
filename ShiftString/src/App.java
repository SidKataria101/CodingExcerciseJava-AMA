import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Create a scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Input reading
        String inputString = getValidatedStringInput(scanner);

        // Read shift positions
        int shiftPositions = getValidatedShiftInput(scanner);

        // Perform the shift
        String result = shiftString(inputString, shiftPositions);
        System.out.println("Shifted String: " + result);

        // Close the scanner
        scanner.close();
    }

    /**
     * Prompts the user for a valid integer input and validates it.
     * @param scanner the Scanner object for reading input
     * @return a validated integer
     */
    private static int getValidatedShiftInput(Scanner scanner) {
        System.out.println("Enter number of positions to shift in range(-1000,1000): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer for shift positions in range (-1000, 1000).");
            scanner.next(); // Clear invalid input
        }
        int shiftPositions = scanner.nextInt();
        return validateInt(shiftPositions);
    }

    /**
     * Prompts the user for a valid string input and validates it.
     * @param scanner the Scanner object for reading input
     * @return a validated string
     */
    private static String getValidatedStringInput(Scanner scanner) {
        while (true) {
            System.out.println("Please enter a string in range(0, 1000]: ");
            var inputString = scanner.nextLine();
            try {
                return validateString(inputString);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
        if (shiftPositions < -1000 || shiftPositions > 1000) {
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
            throw new IllegalArgumentException("Input string cannot be null or empty");
        } else if (!inputString.matches("[a-zA-Z0-9\\\\s.,!?'\\\\-;:@#&*()]+")) {
            throw new IllegalArgumentException("Input string must contain only alphabetic characters, spaces, and the following punctuation: . , ! ? ' - ; : @ # & * ( )");
        } else if (inputString.length() > 1000) {
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
        if (str == null || str.isEmpty()) {
            return str;
        }

        int len = str.length();
        shift = shift % len; // Handle shifts larger than the string length
        if (shift < 0) {
            shift += len; // Convert negative shifts to positive
        }

        return str.substring(len - shift) + str.substring(0, len - shift);
    }
}
