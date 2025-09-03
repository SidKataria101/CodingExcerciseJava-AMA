import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Create a scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Input reading
        System.out.println("Enter a string to shift in range(0, 1000]: ");
        while (!scanner.hasNextLine()) {
            System.out.println("Please enter a valid string in range (0, 1000].");
            scanner.next(); // Clear invalid input
        }
        String inputString = scanner.nextLine();
        validateString(inputString);

        // Read shift positions
        System.out.println("Enter number of positions to shift in range(-1000,1000): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer for shift positions in range (-1000, 1000).");
            scanner.next(); // Clear invalid input
        }
        int shiftPositions = scanner.nextInt();
        validateInt(shiftPositions);

        // Perform the shift
        String result = shiftString(inputString, shiftPositions);
        System.out.println("Shifted String: " + result);

        // Close the scanner
        scanner.close();
    }

    /**
     * Validates the shift positions.
     * @param shiftPositions the number of positions to validate
     * @throws IllegalArgumentException if the input is invalid
     */
    private static void validateInt(int shiftPositions) {
        // Input validation for shift positions
        if (shiftPositions < -1000 || shiftPositions > 1000) {
            throw new IllegalArgumentException("Shift positions must be between -1000 and 1000");
        } 
        // Else input is valid
    }

    /**
     * Validates the input string.
     * @param inputString the string to validate
     * @throws IllegalArgumentException if the input is invalid
     */
    private static void validateString(String inputString) {
        // Input validation
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        } else if (!inputString.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Input string must contain only alphabetic characters");
        } else if (inputString.length() > 1000) {
            throw new IllegalArgumentException("Input string must not exceed 100 characters");
        } 
        // Else input is valid
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
