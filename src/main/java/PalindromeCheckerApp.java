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
        System.out.println("\n--- UC4: Character Array Palindrome Check ---");

        String text = "radar";
        char[] arr = text.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        boolean isPalindrome = true;

        while(start < end) {
            if(arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if(isPalindrome) {
            System.out.println(text + " is a Palindrome");
        } else {
            System.out.println(text + " is NOT a Palindrome");
        }
        System.out.println("\n--- UC5: Stack Based Palindrome Check ---");

        String stackWord = "madam";

        java.util.Stack<Character> stack = new java.util.Stack<>();

// Push characters to stack
        for(int i = 0; i < stackWord.length(); i++) {
            stack.push(stackWord.charAt(i));
        }

// Pop characters to build reversed string
        String reversedWord = "";
        while(!stack.isEmpty()) {
            reversedWord = reversedWord + stack.pop();
        }

// Compare
        if(stackWord.equals(reversedWord)) {
            System.out.println(stackWord + " is a Palindrome");
        } else {
            System.out.println(stackWord + " is NOT a Palindrome");
        }
    }
}