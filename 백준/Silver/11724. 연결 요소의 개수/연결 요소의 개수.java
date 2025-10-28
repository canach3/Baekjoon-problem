import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] adjList;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        adjList = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            adjList[vertex1].add(vertex2);
            adjList[vertex2].add(vertex1);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }


        System.out.println(cnt);
    }

    static void DFS(int start) {
        visited[start] = true;

        for (int next : adjList[start]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}