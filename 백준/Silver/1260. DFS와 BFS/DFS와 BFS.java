import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static Deque<Integer> deque;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        deque = new ArrayDeque<>();

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            nodes.get(start).add(end);
            nodes.get(end).add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(nodes.get(i));
        }

        DFS(V);

        System.out.println();
        Arrays.fill(visited, false);

        visited[V] = true;
        BFS(V);
    }

    static void DFS(int node) {
        visited[node] = true;

        System.out.print(node + " ");

        for (int i = 0; i < nodes.get(node).size(); i++) {
            int nextNode = nodes.get(node).get(i);

            if (!visited[nextNode]) {
                DFS(nextNode);
            }
        }
    }

    static void BFS(int node) {
        System.out.print(node + " ");

        for (int i = 0; i < nodes.get(node).size(); i++) {
            int nextNode = nodes.get(node).get(i);
            if (!visited[nextNode]) {
                deque.addLast(nextNode);
                visited[nextNode] = true;
            }
        }

        if (!deque.isEmpty()) {
            BFS(deque.removeFirst());
        }
    }
}