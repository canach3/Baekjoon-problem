import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new ArrayDeque<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        sb.append('<');
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll()).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append('>');

        System.out.println(sb);
    }
}