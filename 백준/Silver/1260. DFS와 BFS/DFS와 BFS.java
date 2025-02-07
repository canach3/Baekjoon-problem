import java.io.BufferedReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int first = sc.nextInt();

        visited = new boolean[N + 1];
        // visited[0] = true

        for (int i = 0; i < N + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(adjList.get(i));
        }

        // DFS 실행
        DFS(first);
        System.out.println(sb);
        sb = new StringBuilder();

        // visit[] 초기화
        for (int i = 0; i < N + 1; i++) {
            visited[i] = false;
        }

        // BFS 실행
        BFS(first);
        System.out.println(sb);
    }

    static void DFS(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int n : adjList.get(start)) {
            if (!visited[n]) {
                DFS(n);
            }
        }
    }

    static void BFS(int start) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for (int n : adjList.get(current)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}