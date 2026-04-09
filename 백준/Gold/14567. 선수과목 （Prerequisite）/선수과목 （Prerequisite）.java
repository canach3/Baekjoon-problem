import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N + 1];

        List<Integer>[] adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            indegree[v]++;
            adjList[u].add(v);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) deque.addLast(new int[] {i, 1});
        }

        int[] result = new int[N + 1];
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            result[curr[0]] = curr[1];

            for (int next : adjList[curr[0]]) {
                if (--indegree[next] == 0) deque.addLast(new int[] {next, curr[1] + 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}