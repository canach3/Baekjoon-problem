import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int i = 0;
        int j = 1;
        while (i < n) {
            if (deque.isEmpty() || deque.peekLast() < sequence[i]) {
                deque.addLast(j);
                sb.append("+").append("\n");
                j++;
            } else if (deque.peekLast() > sequence[i]) {
                System.out.println("NO");
                return;
            } else {
                deque.removeLast();
                sb.append("-").append("\n");
                i++;
            }
        }

        while(!deque.isEmpty()) {
            deque.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}