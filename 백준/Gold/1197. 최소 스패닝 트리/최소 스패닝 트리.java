import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static List<int[]> edgeList;
    static int[] root;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        root = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            root[i] = i;
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

            int v1Root = findRoot(v1);
            int v2Root = findRoot(v2);

            if (v1Root == v2Root) continue;

            root[v1Root] = root[v2Root];
            sum += cost;
            cnt++;

            if (cnt >= V - 1) break;
        }

        return sum;
    }

    static int findRoot(int v) {
        if (root[v] == v) return v;

        return root[v] = findRoot(root[v]);
    }
}