import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new List[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            DFS(i, 1);

            if (result) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    static void DFS(int current, int cnt) {
        if (cnt >= 5) {
            result = true;
            return;
        }

        visited[current] = true;

        for (int i = 0; i < adjList[current].size(); i++) {
            int next = adjList[current].get(i);

            if (!visited[next]) {
                DFS(next, cnt + 1);
                visited[next] = false;
            }
        }
    }
}