import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static Deque<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
        }

        visited = new boolean[N + 1];
        stack = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.print(sb);
    }

    static void DFS(int current) {
        visited[current] = true;

        for (int next : adjList[current]) {
            if (!visited[next]) DFS(next);
        }

        stack.push(current);
    }
}