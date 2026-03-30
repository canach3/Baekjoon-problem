import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> edges =  new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new int[]{v1, v2, cost});
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int sum = 0;
        int max = 0;
        int cnt = 0;
        for (int[] edge : edges) {
            if (cnt == N - 1) break;

            int v1 = edge[0];
            int v2 = edge[1];
            int cost = edge[2];

            if (union(v1, v2)) {
                sum += cost;
                max = Math.max(max, cost);
                cnt++;
            }
        }

        System.out.println(sum - max);
    }

    static boolean union(int v1, int v2) {
        int v1Root = find(v1);
        int v2Root = find(v2);

        if (v1Root == v2Root) return false;

        parent[v2Root] = v1Root;
        return true;
    }

    static int find(int v) {
        if (parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }
}