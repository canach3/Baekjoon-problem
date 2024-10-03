import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            deque1.offer(sc.nextInt());
        }

        int order = 1;
        while (order < n) {
            if (!deque1.isEmpty() && order == deque1.peek()) {
                deque1.poll();
                order++;
            } else if (!deque2.isEmpty() && order == deque2.peek()) {
                deque2.pop();
                order++;
            } else if (!deque1.isEmpty()) {
                deque2.push(deque1.poll());
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}