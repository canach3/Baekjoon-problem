import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static Edge[] edges;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dist = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] == Long.MAX_VALUE) continue;

                if (dist[edge.u] + edge.cost < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.cost;
                }
            }
        }

        boolean cycle = false;
        for (Edge edge : edges) {
            if (dist[edge.u] == Long.MAX_VALUE) continue;

            if (dist[edge.u] + edge.cost < dist[edge.v]) {
               cycle = true;
               break;
            }
        }

        if (cycle) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(dist[i] == Long.MAX_VALUE ? -1 : dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    static class Edge {
        int u;
        int v;
        long cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
}