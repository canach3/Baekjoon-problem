import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    static List<int[]> edgeList;
    static int[] parent;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < M + 2; j++) {
                map[i][j] -= 1;
            }
        }

        int vNum = 0;
        visited = new boolean[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    getVertex(i, j, ++vNum);
                }
            }
        }

        edgeList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] != -1) {
                    for (int k = 0; k < 4; k++) {
                        getEdge(i, j, map[i][j], 0, k);
                    }
                }
            }
        }

        Collections.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        int result = kruskal(vNum);
        System.out.println(result);
    }

    static int kruskal(int V) {
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        int sum = 0;
        for (int[] edge : edgeList) {
            if (cnt == V - 1) break;

            int v1 = edge[0];
            int v2 = edge[1];
            int cost = edge[2];

            if (union(v1, v2)) {
                sum += cost;
                cnt++;
            }
        }

        if (cnt != V - 1) return -1;
        return sum;
    }

    static boolean union(int v1, int v2) {
        int v1Root = findRoot(v1);
        int v2Root = findRoot(v2);

        if (v1Root == v2Root) return false;

        parent[v2Root] = v1Root;
        return true;
    }

    static int findRoot(int v) {
        if (parent[v] == v) return v;
        return findRoot(parent[v]);
    }

    static void getVertex(int y, int x, int vNum) {
        visited[y][x] = true;
        map[y][x] = vNum;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (!visited[nextY][nextX] && map[nextY][nextX] == 0) {
                getVertex(nextY, nextX, vNum);
            }
        }
    }

    static void getEdge(int y, int x, int currV, int length, int direction) {
        // 경계선인 경우 return
        if (y == 0 || y == N + 1 || x == 0 || x == M + 1) return;

        int newV = map[y][x];

        // 종료 : 다른 섬에 도달했을 때
        if (newV != currV && newV != -1) {
            if (newV < currV) return; // 번호가 더 낮은 섬과의 간선은 이미 구함
            if (length == 2) return; // 다리길이는 2 이상만 가능
            edgeList.add(new int[]{currV, newV, length - 1});
            return;
        }

        int nextY = y + dy[direction];
        int nextX = x + dx[direction];

        // 다음 진행방향이 같은 섬인 경우 return
        if (map[nextY][nextX] == currV) return;

        // 다음 진행방향이 바다인 경우 진행, 길이 + 1
        getEdge(nextY, nextX, currV, length + 1, direction);
    }
}