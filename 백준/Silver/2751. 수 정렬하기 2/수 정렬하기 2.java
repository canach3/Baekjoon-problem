import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            minheap.add(sc.nextInt());
        }

        for(int i = 0; i < N; i++) {
            sb.append(minheap.poll()).append("\n");
        }

        System.out.println(sb);
    }
}