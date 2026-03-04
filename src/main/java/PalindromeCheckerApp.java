public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1 - Welcome Message
        System.out.println("=================================");
        System.out.println("        PALINDROME CHECKER APP        ");
        System.out.println("=================================");

        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Version : 1.0");

        System.out.println("Welcome to the Palindrome Checker Application!");
        System.out.println("The program will check whether a given string is a palindrome.");

        System.out.println("\n------ UC2: Hardcoded Palindrome Check ------");

        // UC2 - Hardcoded Palindrome
        String word = "madam";

        String reversed = new StringBuilder(word).reverse().toString();

        if(word.equals(reversed)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
    }
}