import java.util.*;
import java.io.*;

public class Main {
    static List<Node>[] adjList;
    static boolean[] visited;
    static int farthestNode = 1;
    static int maxDistance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        visited = new boolean[V + 1];
        adjList = new List[V + 1];
        for (int i = 0; i < V + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < V + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while(true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) {
                    break;
                }
                int length = Integer.parseInt(st.nextToken());

                adjList[start].add(new Node(end, length));
                adjList[end].add(new Node(start, length));
            }
        }

        DFS(1, 0);
        visited = new boolean[V + 1];
        DFS(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void DFS(int start, int distance) {
        visited[start] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = start;
        }

        for (int i = 0; i < adjList[start].size(); i++) {
            Node next = adjList[start].get(i);

            if (!visited[next.num]) {
                DFS(next.num, distance + next.length);
            }
        }
    }

    static class Node {
        int num;
        int length;

        Node(int num, int length) {
            this.num = num;
            this.length = length;
        }
    }
}