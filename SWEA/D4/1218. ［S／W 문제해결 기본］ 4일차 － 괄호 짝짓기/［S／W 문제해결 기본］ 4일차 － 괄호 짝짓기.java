import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            Stack<Character> stack = new Stack<>();
            stack.push('x');

            int len = Integer.parseInt(br.readLine());
            String input = br.readLine();

            boolean isOk = true;

            for (Character c : input.toCharArray()) {
                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                    case '<':
                        stack.push(c);
                        break;
                    case ')':
                        if (stack.pop() != '(') isOk = false;
                        break;
                    case ']':
                        if (stack.pop() != '[') isOk = false;
                        break;
                    case '}':
                        if (stack.pop() != '{') isOk = false;
                        break;
                    case '>':
                        if (stack.pop() != '<') isOk = false;
                }

                if (!isOk) break;
            }

            if (stack.peek() != 'x') {
                isOk = false;
            }

            int result = isOk ? 1 : 0;

            System.out.println("#" + testCase + " " + result);
        }
    }
}