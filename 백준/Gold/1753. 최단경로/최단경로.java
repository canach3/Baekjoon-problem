import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static List<List<int[]>> adjList;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        cost = new int[V + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        int start = Integer.parseInt(br.readLine());
        cost[start] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[1];

            if (cost[curr[0]] < currCost) continue;

            for (int[] next : adjList.get(curr[0])) {
                int nextV = next[0];
                int nextCost = next[1];

                if (currCost + nextCost < cost[nextV]) {
                    cost[nextV] = currCost + nextCost;

                    pq.add(new int[]{nextV, cost[nextV]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (cost[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }

            sb.append(cost[i]).append("\n");
        }

        System.out.print(sb);
    }
}