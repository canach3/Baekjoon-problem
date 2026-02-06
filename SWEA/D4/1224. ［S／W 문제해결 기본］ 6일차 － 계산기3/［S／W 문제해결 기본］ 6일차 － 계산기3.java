import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= 10; testCase++) {
            Map<Character, Integer> priority = new HashMap<>();
            priority.put('(', 1);
            priority.put('+', 2);
            priority.put('-', 2);
            priority.put('*', 3);
            priority.put('/', 3);
            priority.put('%', 3);

            Deque<Character> operators = new ArrayDeque<>();
            StringBuilder postfix = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            for (char c : input.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    postfix.append(c);
                } else {
                    if (operators.isEmpty() || c == '(') {
                        operators.push(c);
                    } else if (c == ')') {
                        while (operators.peek() != '(') {
                            postfix.append(operators.pop());
                        }

                        operators.pop();
                    } else {
                        while (!operators.isEmpty() && priority.get(c) <= priority.get(operators.peek())) {
                            postfix.append(operators.pop());
                        }
                        operators.push(c);
                    }
                }
            }

            while (!operators.isEmpty()) {
                postfix.append(operators.pop());
            }


            Stack<Integer> operands = new Stack<>();

            for (char c : postfix.toString().toCharArray()) {
                if (c >= '0' && c <= '9') {
                    operands.push(c - '0');
                } else {
                    int result = 0;
                    int op2 = operands.pop();
                    int op1 = operands.pop();

                    switch (c) {
                        case '+':
                            result = op1 + op2;
                            break;
                        case '-':
                            result = op1 - op2;
                            break;
                        case '*':
                            result = op1 * op2;
                            break;
                        case '/':
                            result = op1 / op2;
                            break;
                        case '%':
                            result = op1 % op2;
                            break;
                    }
                    operands.push(result);
                }
            }

            sb.append(("#" + testCase + " " + operands.pop()) + "\n");
        }
        System.out.print(sb);
    }
}