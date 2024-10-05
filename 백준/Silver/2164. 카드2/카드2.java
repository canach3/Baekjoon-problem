import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }

        while (deque.size() != 1) {
            deque.pop();
            deque.offerLast(deque.pop());
        }

        System.out.println(deque.peek());
    }
}