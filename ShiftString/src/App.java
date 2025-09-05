import java.util.Scanner;

public class App {

    private static final int MAX = 1000;
    private static final int MIN = -1000;

    public static void main(String[] args) throws Exception {
        // Create a scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Input reading
        String inputString = getValidatedStringInput(scanner);

        // Read shift positions
        int shiftPositions = getValidatedShiftInput(scanner);

        // Perform the shift
        String result = shiftString(inputString, shiftPositions);
        System.out.println("\n" + "Shifted String: \"" + result + "\"");

        // Close the scanner
        scanner.close();
    }

    /**
     * Prompts the user for a valid integer input and validates it.
     * @param scanner the Scanner object for reading input
     * @return a validated integer
     */
    private static int getValidatedShiftInput(Scanner scanner) {
        System.out.println("Enter a number between -1000 and 1000 to shift your string by");
        System.out.println("(negative = left shift, positive = right shift):");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Please enter a valid integer for shift positions in range (-1000, 1000).");
                continue;
            }
            try {
                int shiftPositions = Integer.parseInt(line);
                return validateInt(shiftPositions);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer for shift positions in range (-1000, 1000).");
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
            System.out.println("Please enter a string with maximum 1000 characters including whitespaces: ");
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
        if (shiftPositions < MIN || shiftPositions > MAX) {
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
        } else if (!inputString.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Input string must contain only alphabetic letters (a-z, A-Z) and spaces");
        } else if (inputString.length() > MAX) {
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
        if (str == null || str.isEmpty() || shift == 0) return str;

        // Normalize shift to be within the length of the string
        int len = str.length();
        shift = shift % len;

        if (shift < 0) {    // Left shift
            int leftShift = -shift;
            return str.substring(leftShift) + str.substring(0, leftShift);
        } else {  // Right shift
            return str.substring(len - shift) + str.substring(0, len - shift);
        }
    }
}
