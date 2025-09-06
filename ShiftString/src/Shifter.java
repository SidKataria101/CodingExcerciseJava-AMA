public class Shifter {
    
    /**
     * Shifts the string by the specified number of positions.
     * @param str the string to shift
     * @param shift the number of positions to shift
     * @return the shifted string
     */
    public static String shiftString(String str, int shift) {
        // Return the string as is if no shift is needed
        if (str == null || str.isEmpty() || shift == 0) {
            ConsoleUI.logInfo(str + " requires no shifting.");
            return str;
        }

        // Normalize shift to be within the length of the string
        int len = str.length();
        shift = shift % len;

        if (shift < 0) {    // Left shift
            int leftShift = -shift;
            ConsoleUI.logInfo(str + " will be left shifted by " + leftShift + " positions.");
            return str.substring(leftShift) + str.substring(0, leftShift);
        } else {  // Right shift
            ConsoleUI.logInfo(str + " will be right shifted by " + shift + " positions.");
            return str.substring(len - shift) + str.substring(0, len - shift);
        }
    }
}
