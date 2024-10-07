import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            deque1.offer(sc.nextInt());
        }

        for (int i = 1; i <= n; i++) {
            deque2.offer(i);
        }

        while (!deque1.isEmpty()) {
            int t = deque1.pollFirst();  
            sb.append(deque2.pollFirst()).append(" ");  

           
            if (deque1.isEmpty()) {
                break;  
            }

            if (t > 0) {
               
                for (int i = 0; i < t - 1; i++) {
                    deque1.offerLast(deque1.pollFirst());
                    deque2.offerLast(deque2.pollFirst());
                }
            } else {
               
                for (int i = 0; i < -t; i++) {
                    deque1.offerFirst(deque1.pollLast());
                    deque2.offerFirst(deque2.pollLast());
                }
            }
        }

        System.out.println(sb.toString().trim());  
    }
}