import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            sb.append("#").append(testCase).append(" ");
            int T = Integer.parseInt(br.readLine().trim());

            Deque<Integer> queue = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                queue.offerLast(Integer.parseInt(st.nextToken()));
            }

            int minus = 1;
            while (true) {
                queue.offerLast(Math.max(queue.pollFirst() - minus++, 0));

                if (queue.peekLast() == 0) break;
                if (minus == 6) minus = 1;
            }

            while (!queue.isEmpty()) {
                sb.append(queue.pollFirst()).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
