import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int X;
    static int[] dist;
    static int[][] totalCost;
    static List<int[]>[] adjList;
    static List<int[]>[] reverseAdjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        reverseAdjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            reverseAdjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[u].add(new int[]{v, cost});
            reverseAdjList[v].add(new int[]{u, cost});
        }

        dist = new int[N + 1];
        totalCost = new int[N + 1][2];

        dijkstra();
        rDijkstra();

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, totalCost[i][0] + totalCost[i][1]);
        }

        System.out.println(max);
    }

    static void dijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{X, 0});

        while (!pq.isEmpty()) {
            int[] cTmp = pq.poll();
            int curr = cTmp[0];
            int cost = cTmp[1];

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

        for (int i = 1; i <= N; i++) totalCost[i][0] = dist[i];
    }

    static void rDijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{X, 0});

        while (!pq.isEmpty()) {
            int[] cTmp = pq.poll();
            int curr = cTmp[0];
            int cost = cTmp[1];

            if (cost > dist[curr]) continue;

            for (int[] nTmp : reverseAdjList[curr]) {
                int next = nTmp[0];
                int newCost = cost + nTmp[1];

                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.add(new int[]{next, newCost});
                }
            }
        }

        for (int i = 1; i <= N; i++) totalCost[i][1] = dist[i];
    }
}