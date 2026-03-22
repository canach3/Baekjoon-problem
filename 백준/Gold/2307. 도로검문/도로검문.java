import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Map<Integer, Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][2];
        for (int i = 2; i <= N; i++) {
            dist[i][0] = Integer.MAX_VALUE; // 최단거리, 자신의 이전노드 저장
        }

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new HashMap<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(v1).put(v2, cost);
            adjList.get(v2).put(v1, cost);
        }

        int shortest = dijkstra(dist);
        int max = -1;

        int curr = N;
        while (curr != 1) {
            int prev = dist[curr][1];

            int tmp = adjList.get(curr).get(prev);
            adjList.get(curr).remove(prev);
            adjList.get(prev).remove(curr);

            int[][] tmpDist = new int[N + 1][2];
            for (int i = 2; i <= N; i++) {
                tmpDist[i][0] = Integer.MAX_VALUE;
            }

            int length = dijkstra(tmpDist);
            if (length == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }

            int diff = length - shortest;
            max = Math.max(max, diff);

            adjList.get(curr).put(prev, tmp);
            adjList.get(prev).put(curr, tmp);

            curr = prev;
        }

        System.out.println(max);
    }

    static int dijkstra(int[][] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currV = curr[0];
            int currCost = curr[1];

            if (currV == N) break;
            if (dist[currV][0] < currCost) continue;

            for (int nextV : adjList.get(currV).keySet()) {
                int newCost = currCost + adjList.get(currV).get(nextV);

                if (newCost < dist[nextV][0]) {
                    dist[nextV][0] = newCost;
                    dist[nextV][1] = currV;
                }

                pq.add(new int[]{nextV, newCost});
            }
        }

        return dist[N][0];
    }
}