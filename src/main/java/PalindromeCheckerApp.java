public class PalindromeCheckerApp {

    static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("        PALINDROME CHECKER APP");
        System.out.println("=================================");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Version : 1.0");

        System.out.println("\n--- UC2 ---");
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println(word.equals(reversed) ? word + " is a Palindrome" : word + " is NOT a Palindrome");

        System.out.println("\n--- UC3 ---");
        String original = "level";
        String reverse = "";
        for (int i = original.length() - 1; i >= 0; i--) reverse += original.charAt(i);
        System.out.println(original.equals(reverse) ? original + " is a Palindrome" : original + " is NOT a Palindrome");

        System.out.println("\n--- UC4 ---");
        String text = "radar";
        char[] arr = text.toCharArray();
        int start = 0, end = arr.length - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println(isPalindrome ? text + " is a Palindrome" : text + " is NOT a Palindrome");

        System.out.println("\n--- UC5 ---");
        String stackWord = "madam";
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : stackWord.toCharArray()) stack.push(c);
        String reversedWord = "";
        while (!stack.isEmpty()) reversedWord += stack.pop();
        System.out.println(stackWord.equals(reversedWord) ? stackWord + " is a Palindrome" : stackWord + " is NOT a Palindrome");

        System.out.println("\n--- UC6 ---");
        String data = "level";
        java.util.Stack<Character> stack2 = new java.util.Stack<>();
        java.util.Queue<Character> queue = new java.util.LinkedList<>();
        for (char c : data.toCharArray()) {
            stack2.push(c);
            queue.add(c);
        }
        boolean isPalin = true;
        while (!stack2.isEmpty()) {
            if (stack2.pop() != queue.remove()) {
                isPalin = false;
                break;
            }
        }
        System.out.println(isPalin ? data + " is a Palindrome" : data + " is NOT a Palindrome");

        System.out.println("\n--- UC7 ---");
        String dequeWord = "racecar";
        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();
        for (char c : dequeWord.toCharArray()) deque.addLast(c);
        boolean palindrome = true;
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                palindrome = false;
                break;
            }
        }
        System.out.println(palindrome ? dequeWord + " is a Palindrome" : dequeWord + " is NOT a Palindrome");

        System.out.println("\n--- UC8 ---");

        class Node {
            char data;
            Node next;
            Node(char data) { this.data = data; }
        }

        String linkedWord = "radar";
        Node head = null, tail = null;

        for (char c : linkedWord.toCharArray()) {
            Node node = new Node(c);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        while (slow != null) {
            Node next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        Node first = head, second = prev;
        boolean isPalindromeLL = true;

        while (second != null) {
            if (first.data != second.data) {
                isPalindromeLL = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        System.out.println(isPalindromeLL ? linkedWord + " is a Palindrome" : linkedWord + " is NOT a Palindrome");

        System.out.println("\n--- UC9 ---");
        String recWord = "madam";
        boolean result = isPalindromeRecursive(recWord, 0, recWord.length() - 1);
        System.out.println(result ? recWord + " is a Palindrome" : recWord + " is NOT a Palindrome");

        System.out.println("\n--- UC10 ---");
        String input = "Never Odd Or Even";
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        String reversedInput = "";
        for (int i = normalized.length() - 1; i >= 0; i--) reversedInput += normalized.charAt(i);
        System.out.println(normalized.equals(reversedInput) ? "\"" + input + "\" is a Palindrome" : "\"" + input + "\" is NOT a Palindrome");

        System.out.println("\n--- UC11 ---");
        PalindromeChecker checker = new PalindromeChecker();
        String oopWord = "level";
        System.out.println(checker.checkPalindrome(oopWord) ? oopWord + " is a Palindrome" : oopWord + " is NOT a Palindrome");

        System.out.println("\n--- UC12 ---");
        PalindromeStrategy strategy = new StackStrategy();
        String strategyWord = "madam";
        System.out.println(strategy.checkPalindrome(strategyWord) ? strategyWord + " is a Palindrome (Stack Strategy)" : strategyWord + " is NOT a Palindrome");

        strategy = new DequeStrategy();
        System.out.println(strategy.checkPalindrome(strategyWord) ? strategyWord + " is a Palindrome (Deque Strategy)" : strategyWord + " is NOT a Palindrome");
        System.out.println("\n--- UC13: Performance Comparison ---");

        String perfWord = "racecar";

// Stack Strategy timing
        PalindromeStrategy stackStrategy = new StackStrategy();

        long startTime = System.nanoTime();
        boolean stackResult = stackStrategy.checkPalindrome(perfWord);
        long endTime = System.nanoTime();

        long stackTime = endTime - startTime;

// Deque Strategy timing
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        startTime = System.nanoTime();
        boolean dequeResult = dequeStrategy.checkPalindrome(perfWord);
        endTime = System.nanoTime();

        long dequeTime = endTime - startTime;

        System.out.println("Stack Strategy Result: " + stackResult);
        System.out.println("Stack Strategy Time: " + stackTime + " ns");

        System.out.println("Deque Strategy Result: " + dequeResult);
        System.out.println("Deque Strategy Time: " + dequeTime + " ns");
    }

    static class PalindromeChecker {
        public boolean checkPalindrome(String str) {
            String reversed = "";
            for (int i = str.length() - 1; i >= 0; i--) reversed += str.charAt(i);
            return str.equals(reversed);
        }
    }
}

interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String str) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : str.toCharArray()) stack.push(c);

        String reversed = "";

        while (!stack.isEmpty()) reversed += stack.pop();

        return str.equals(reversed);
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String str) {

        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        for (char c : str.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }

        return true;
    }
}