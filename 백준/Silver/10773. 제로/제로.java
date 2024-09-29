import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int sum = 0;

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();

            if (input == 0) {
                sum -= stack.pop();
            } else {
                stack.push(input);
                sum += input;
            }
        }

        System.out.println(sum);
    }
}