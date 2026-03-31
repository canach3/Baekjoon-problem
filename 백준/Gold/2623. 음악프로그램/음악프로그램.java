import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            int[] nodes = new int[size];
            for (int j = 0; j < size; j++) {
                nodes[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {

                    int u = nodes[j];
                    int v = nodes[k];

                    adjList[u].add(v);
                    indegree[v]++;
                }
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) deque.addLast(i);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            int curr = deque.pollFirst();
            sb.append(curr).append("\n");
            cnt++;

            for (int next : adjList[curr]) {
                if (--indegree[next] == 0) deque.addLast(next);
            }
        }

        System.out.print(cnt == N ? sb : 0);
    }
}