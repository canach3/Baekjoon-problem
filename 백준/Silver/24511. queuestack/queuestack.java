import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(reader.readLine());

        StringTokenizer input1 = new StringTokenizer(reader.readLine());
        StringTokenizer input2 = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(input2.nextToken());

            if (Integer.parseInt(input1.nextToken()) == 0) {
                deque.offer(element);
            }
        }

        int m = Integer.parseInt(reader.readLine());

        StringTokenizer input3 = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            int element = Integer.parseInt(input3.nextToken());

            deque.offerFirst(element);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}