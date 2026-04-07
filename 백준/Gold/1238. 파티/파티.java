import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dist;
    static int[][] totalCost;
    static List<int[]>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            adjList[Integer.parseInt(st.nextToken())].add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        dist = new int[N + 1];
        totalCost = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            dijkstra(i, X);
        }
        dijkstra(X, -1);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, totalCost[i][0] + totalCost[i][1]);
        }

        System.out.println(max);
    }

    static void dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cTmp = pq.poll();
            int curr = cTmp[0];
            int cost = cTmp[1];

            if (curr == end) break;
            if (cost > dist[curr]) continue;

            for (int[] nTmp : adjList[curr]) {
                int next = nTmp[0];
                int newCost = cost + nTmp[1];

                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.add(new int[]{next, newCost});
                }
            }
        }

        if (end == -1) {
            for (int i = 1; i <= N; i++) totalCost[i][1] = dist[i];
        } else {
            totalCost[start][0] = dist[end];
        }
    }
}