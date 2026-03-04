public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1 - Welcome Message
        System.out.println("=================================");
        System.out.println("        PALINDROME CHECKER APP        ");
        System.out.println("=================================");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Version : 1.0");

        // UC2 - Hardcoded Palindrome
        System.out.println("\n--- UC2: Hardcoded Palindrome Check ---");

        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        if(word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }

        // UC3 - Reverse String using Loop
        System.out.println("\n--- UC3: Palindrome using Reverse Loop ---");

        String original = "level";
        String reverse = "";

        for(int i = original.length() - 1; i >= 0; i--) {
            reverse = reverse + original.charAt(i);
        }

        if(original.equals(reverse)) {
            System.out.println(original + " is a Palindrome");
        } else {
            System.out.println(original + " is NOT a Palindrome");
        }
    }
}