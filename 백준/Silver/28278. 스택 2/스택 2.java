import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();

            if (input == 1) {
                stack.push(sc.nextInt());
            }

            if (input == 2) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            }

            if (input == 3) {
                sb.append(stack.size()).append("\n");
            }

            if (input == 4) {
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }

            if (input == 5) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}