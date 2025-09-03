import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String original = "abcdef";
        int shift = 2;
        String shifted = shiftString(original, shift);
        System.out.println("Original: " + original);
        System.out.println("Shifted: " + shifted);

    }

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
