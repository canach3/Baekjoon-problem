import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static List<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        adjList = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(adjList[i]);
        }

        DFS(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        BFS(V);

        System.out.println(sb);
    }

    static void DFS(int current) {
        visited[current] = true;
        sb.append(current).append(" ");

        for (int i = 0; i < adjList[current].size(); i++) {
            int next = adjList[current].get(i);

            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    static void BFS(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(start);

        while (!deque.isEmpty()) {
            int current = deque.removeLast();
            visited[current] = true;
            sb.append(current).append(" ");

            for (int i = 0; i < adjList[current].size(); i++) {
                int next = adjList[current].get(i);

                if (!visited[next]) {
                    deque.addFirst(next);
                    visited[next] = true;
                }
            }
        }
    }
}