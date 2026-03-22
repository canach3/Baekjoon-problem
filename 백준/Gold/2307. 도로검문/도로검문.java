import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<int[]>> adjList;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(v1).add(new int[]{v2, cost});
            adjList.get(v2).add(new int[]{v1, cost});
        }

        parent = new int[N + 1];

        int shortest = dijkstra(0, 0);

        if (shortest == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        int maxDelay = -1;
        int curr = N;

        while (curr != 1) {
            int prev = parent[curr];

            int length = dijkstra(curr, prev);

            if (length == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }

            int diff = length - shortest;
            maxDelay = Math.max(maxDelay, diff);

            curr = prev;
        }

        System.out.println(maxDelay);
    }

    static int dijkstra(int blockU, int blockV) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new int[]{1, 0});
        dist[1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currV = curr[0];
            int currCost = curr[1];

            if (dist[currV] < currCost) continue;

            for (int[] next : adjList.get(currV)) {
                int nextV = next[0];
                int nextCost = next[1];

                if ((currV == blockU && nextV == blockV) || (currV == blockV && nextV == blockU)) {
                    continue;
                }

                int newCost = currCost + nextCost;

                if (newCost < dist[nextV]) {
                    dist[nextV] = newCost;

                    if (blockU == 0 && blockV == 0) {
                        parent[nextV] = currV;
                    }

                    pq.add(new int[]{nextV, newCost});
                }
            }
        }

        return dist[N];
    }
}