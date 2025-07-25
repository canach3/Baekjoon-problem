import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            minheap.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < K; i++) {
            if(i == K-1) {
                System.out.println(minheap.peek());
            }
            minheap.poll();
        }
    }
}