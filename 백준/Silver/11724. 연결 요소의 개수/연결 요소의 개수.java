import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> nodes;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];

        nodes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            nodes.get(startNode).add(endNode);
            nodes.get(endNode).add(startNode);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                cnt++;
                DFS(i);
            }
        }

        System.out.println(cnt);
    }

    static void DFS(int node) {
        visit[node] = true;

        for (int i = 0; i < nodes.get(node).size(); i++) {
            int adjNode = nodes.get(node).get(i);
            if (!visit[adjNode]) {
                DFS(adjNode);
            }
        }
    }
}