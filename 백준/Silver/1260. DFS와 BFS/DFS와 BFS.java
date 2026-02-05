import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<ArrayList<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(adjList.get(i));
        }

        visited = new boolean[N + 1];
        DFS(V);

        sb.append("\n");

        visited = new boolean[N + 1];
        BFS(V);

        System.out.println(sb);
    }

    static void DFS(int current) {
        visited[current] = true;
        sb.append(current).append(" ");

        for (int i = 0; i < adjList.get(current).size(); i++) {
            int next = adjList.get(current).get(i);

            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    static void BFS(int current) {
        visited[current] = true;
        sb.append(current).append(" ");

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < adjList.get(current).size(); i++) {
            int adjNode = adjList.get(current).get(i);
            queue.add(adjNode);
            visited[adjNode] = true;
        }

        while(!queue.isEmpty()) {
            int next = queue.poll();

            sb.append(next).append(" ");

            for (int i = 0; i < adjList.get(next).size(); i++) {
                int adjNode = adjList.get(next).get(i);

                if (!visited[adjNode]) {
                    queue.add(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
    }
}