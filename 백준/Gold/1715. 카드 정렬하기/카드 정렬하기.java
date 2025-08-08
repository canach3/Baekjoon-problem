import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            minheap.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (minheap.size() > 1) {
            int sum = minheap.remove() + minheap.remove();
            result += sum;
            minheap.add(sum);
        }

        System.out.println(result);
    }
}