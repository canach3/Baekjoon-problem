import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> adjList;
    static int[] children;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        children = new int[N + 1];
        Arrays.fill(children, 1);

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        visited = new boolean[N + 1];
        DFS(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(children[Integer.parseInt(br.readLine().trim())]).append("\n");
        }

        System.out.print(sb);
    }

    static int DFS(int current) {
        visited[current] = true;

        for (int next : adjList.get(current)) {
            if (visited[next]) continue;

            children[current] += DFS(next);
        }

        return children[current];
    }
}