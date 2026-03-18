import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static List<List<int[]>> adjList; // 인접 리스트: int[]{도착정점, 가중치}
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 인접리스트, 방문배열 초기화 (정점 번호는 1부터 시작이므로 V + 1 크기 할당)
        adjList = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(v1).add(new int[]{v2, cost});
            adjList.get(v2).add(new int[]{v1, cost});
        }

        long result = prim();

        System.out.println(result);
    }

    static long prim() {
        int cnt = 0;
        long sum = 0;

        // 우선순위 큐: int[]{정점, 비용} -> 비용(인덱스 1) 기준 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // 임의의 시작점(1번 정점)을 큐에 삽입 (시작점 비용은 0)
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            // 현재 트리에서 갈 수 있는 정점중 가장 최소비용으로 갈 수 있는 정점 뽑기
            int[] curr = pq.poll();
            int v = curr[0];
            int cost = curr[1];

            // 이미 트리에 포함된 정점이라면 (사이클을 만드는 경우) 패스
            if (visited[v]) continue;

            // 트리에 포함시키고 방문처리
            visited[v] = true;
            cnt++;
            sum += cost;

            // 모든 정점(V개)이 트리에 포함되었다면 조기 종료
            if (cnt == V) break;

            // 현재 정점과 연결된 간선들 중, 아직 방문하지 않은 정점으로 가는 간선을 큐에 추가
            for (int[] next : adjList.get(v)) {
                if (!visited[next[0]]) {
                    pq.offer(next);
                }
            }
        }

        return sum;
    }
}