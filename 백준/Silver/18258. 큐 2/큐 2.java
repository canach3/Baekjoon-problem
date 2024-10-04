import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt((bf.readLine()));
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split(" ");
            if (input[0].equals("push")) {
                deque.push(Integer.parseInt(input[1]));
            }

            if (input[0].equals("pop")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
            }

            if (input[0].equals("size")) {
                sb.append(deque.size()).append("\n");
            }

            if (input[0].equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }

            if (input[0].equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }

            if (input[0].equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}