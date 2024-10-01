import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            Stack<Character> stack = new Stack<>();
            String input = sc.nextLine();

            if (input.equals(".")) {
                break;
            }

            boolean isBalance = true;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                    stack.push(input.charAt(i));
                }

                if (input.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        isBalance = false;
                        break;
                    }

                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isBalance = false;
                        break;
                    }
                }

                if (input.charAt(i) == ']') {
                    if (stack.isEmpty()) {
                        isBalance = false;
                        break;
                    }

                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isBalance = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isBalance = false;
            }

            if (isBalance) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}