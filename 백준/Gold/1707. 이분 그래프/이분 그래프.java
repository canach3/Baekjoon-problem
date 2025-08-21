import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] adjList;
    static int[] visited;
    static boolean isBGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[V + 1];
            visited = new int[V + 1];

            for (int j = 1; j <= V; j++) {
                adjList[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                adjList[start].add(end);
                adjList[end].add(start);
            }

            isBGraph = true;

            for (int v = 1; v <= V; v++) {
                if (!isBGraph) break; 
                if (visited[v] == 0) {
                    DFS(v, 1);
                }
            }

            System.out.println(isBGraph ? "YES" : "NO");
        }
    }

    static void DFS(int currentNode, int visit) {
        if (!isBGraph) return;
        visited[currentNode] = visit;

        for (int i = 0; i < adjList[currentNode].size(); i++) {
            int nextNode = adjList[currentNode].get(i);

            if (visited[nextNode] == 0) {
                if (visit == 1) {
                    DFS(nextNode, 2);
                }
                if (visit == 2) {
                    DFS(nextNode, 1);
                }
            } else {
                if (visited[nextNode] == visit) {
                    isBGraph = false;
                    return;
                }
            }
        }
    }
}