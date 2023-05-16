import java.util.Scanner;

public class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int a) {
        maxSize = a;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public String reverseString(String input) {
        char[] charArray = input.toCharArray();
        Stack stack = new Stack(input.length());
        for (int i = 0; i < input.length(); i++) {
            stack.push(charArray[i]);
        }
        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan string: ");
        String input = scanner.nextLine();
        Stack stack = new Stack(input.length());
        String reversedString = stack.reverseString(input);
        System.out.println("Reversed: " + reversedString);
    }
}
