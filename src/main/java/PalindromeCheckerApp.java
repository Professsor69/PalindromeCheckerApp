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
        System.out.println("\n--- UC6: Queue + Stack Palindrome Check ---");

        String data = "level";

        java.util.Stack<Character> stack2 = new java.util.Stack<>();
        java.util.Queue<Character> queue = new java.util.LinkedList<>();

// Push into stack and enqueue into queue
        for(int i = 0; i < data.length(); i++) {
            stack2.push(data.charAt(i));
            queue.add(data.charAt(i));
        }

        boolean isPalin = true;

        while(!stack2.isEmpty()) {
            if(stack2.pop() != queue.remove()) {
                isPalin = false;
                break;
            }
        }

        if(isPalin) {
            System.out.println(data + " is a Palindrome");
        } else {
            System.out.println(data + " is NOT a Palindrome");
        }
        System.out.println("\n--- UC7: Deque Based Optimized Palindrome Check ---");

        String dequeWord = "racecar";

        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

// Insert characters into deque
        for(int i = 0; i < dequeWord.length(); i++) {
            deque.addLast(dequeWord.charAt(i));
        }

        boolean palindrome = true;

// Compare front and rear
        while(deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if(front != rear) {
                palindrome = false;
                break;
            }
        }

        if(palindrome) {
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

// Build linked list
        Node head = null;
        Node tail = null;

        for(int i = 0; i < linkedWord.length(); i++) {
            Node newNode = new Node(linkedWord.charAt(i));

            if(head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

// Find middle (fast/slow pointer)
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

// Reverse second half
        Node prev = null;
        Node curr = slow;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

// Compare halves
        Node first = head;
        Node second = prev;

        boolean isPalindromeLL = true;

        while(second != null) {
            if(first.data != second.data) {
                isPalindromeLL = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        if(isPalindromeLL) {
            System.out.println(linkedWord + " is a Palindrome");
        } else {
            System.out.println(linkedWord + " is NOT a Palindrome");
        }
    }
}