import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static List<int[]> edgeList;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        edgeList = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList.add(new int[]{v1, v2, cost});
        }

        Collections.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        long result = kruskal();
        System.out.println(result);
    }

    static long kruskal() {
        long sum = 0;

        int cnt = 0;
        for (int[] edge : edgeList) {
            int v1 = edge[0];
            int v2 = edge[1];
            int cost = edge[2];

            if (union(v1, v2)) {
                sum += cost;
                cnt++;
            }

            if (cnt >= V - 1) break;
        }

        return sum;
    }

    static boolean union(int v1, int v2) {
        int v1Root = find(v1);
        int v2Root = find(v2);

        // 사이클을 만드는 경우
        if (v1Root == v2Root) return false;

        parent[v2Root] = v1Root;
        return true;
    }

    static int find(int v) {
        if (parent[v] == v) return v;

        return parent[v] = find(parent[v]);
    }
}