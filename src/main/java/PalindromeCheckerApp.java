public class PalindromeCheckerApp {

    static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("        PALINDROME CHECKER APP        ");
        System.out.println("=================================");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Version : 1.0");

        System.out.println("\n--- UC2: Hardcoded Palindrome Check ---");

        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }

        System.out.println("\n--- UC3: Palindrome using Reverse Loop ---");

        String original = "level";
        String reverse = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reverse = reverse + original.charAt(i);
        }

        if (original.equals(reverse)) {
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

        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println(text + " is a Palindrome");
        } else {
            System.out.println(text + " is NOT a Palindrome");
        }

        System.out.println("\n--- UC5: Stack Based Palindrome Check ---");

        String stackWord = "madam";
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (int i = 0; i < stackWord.length(); i++) {
            stack.push(stackWord.charAt(i));
        }

        String reversedWord = "";
        while (!stack.isEmpty()) {
            reversedWord = reversedWord + stack.pop();
        }

        if (stackWord.equals(reversedWord)) {
            System.out.println(stackWord + " is a Palindrome");
        } else {
            System.out.println(stackWord + " is NOT a Palindrome");
        }

        System.out.println("\n--- UC6: Queue + Stack Palindrome Check ---");

        String data = "level";

        java.util.Stack<Character> stack2 = new java.util.Stack<>();
        java.util.Queue<Character> queue = new java.util.LinkedList<>();

        for (int i = 0; i < data.length(); i++) {
            stack2.push(data.charAt(i));
            queue.add(data.charAt(i));
        }

        boolean isPalin = true;

        while (!stack2.isEmpty()) {
            if (stack2.pop() != queue.remove()) {
                isPalin = false;
                break;
            }
        }

        if (isPalin) {
            System.out.println(data + " is a Palindrome");
        } else {
            System.out.println(data + " is NOT a Palindrome");
        }

        System.out.println("\n--- UC7: Deque Based Optimized Palindrome Check ---");

        String dequeWord = "racecar";
        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        for (int i = 0; i < dequeWord.length(); i++) {
            deque.addLast(dequeWord.charAt(i));
        }

        boolean palindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                palindrome = false;
                break;
            }
        }

        if (palindrome) {
            System.out.println(dequeWord + " is a Palindrome");
        } else {
            System.out.println(dequeWord + " is NOT a Palindrome");
        }

        System.out.println("\n--- UC8: Linked List Based Palindrome Check ---");

        class Node {
            char data;
            Node next;

            Node(char data) {
                this.data = data;
                this.next = null;
            }
        }

        String linkedWord = "radar";

        Node head = null;
        Node tail = null;

        for (int i = 0; i < linkedWord.length(); i++) {
            Node newNode = new Node(linkedWord.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node curr = slow;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node first = head;
        Node second = prev;

        boolean isPalindromeLL = true;

        while (second != null) {
            if (first.data != second.data) {
                isPalindromeLL = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        if (isPalindromeLL) {
            System.out.println(linkedWord + " is a Palindrome");
        } else {
            System.out.println(linkedWord + " is NOT a Palindrome");
        }

        System.out.println("\n--- UC9: Recursive Palindrome Check ---");

        String recWord = "madam";

        boolean result = isPalindromeRecursive(recWord, 0, recWord.length() - 1);

        if (result) {
            System.out.println(recWord + " is a Palindrome");
        } else {
            System.out.println(recWord + " is NOT a Palindrome");
        }

        System.out.println("\n--- UC10: Case-Insensitive & Space-Ignored Palindrome ---");

        String input = "Never Odd Or Even";

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        String reversedInput = "";

        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversedInput = reversedInput + normalized.charAt(i);
        }

        if (normalized.equals(reversedInput)) {
            System.out.println("\"" + input + "\" is a Palindrome (ignoring case & spaces)");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome");
        }

        System.out.println("\n--- UC11: Object-Oriented Palindrome Service ---");

        PalindromeChecker checker = new PalindromeChecker();

        String oopWord = "level";

        if (checker.checkPalindrome(oopWord)) {
            System.out.println(oopWord + " is a Palindrome");
        } else {
            System.out.println(oopWord + " is NOT a Palindrome");
        }
    }

    static class PalindromeChecker {

        public boolean checkPalindrome(String str) {

            String reversed = "";

            for (int i = str.length() - 1; i >= 0; i--) {
                reversed = reversed + str.charAt(i);
            }

            return str.equals(reversed);
        }
    }
}