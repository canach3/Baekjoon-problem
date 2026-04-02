import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] parent;
    static int[] cnt;
    static int[][] map;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = new int[N * M];
        parent = new int[N * M];
        for (int i = 0; i < N * M; i++) {
            parent[i] = i;
        }

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) continue;
                BFS(i, j);
            }
        }

        // 결과 찾기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) sb.append(0);
                else sb.append(getCount(i, j) % 10);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void BFS(int y, int x) {
        int idx = y * M + x;

        // 이미 다른 타일에 속한 경우 넘어가기
        if (parent[idx] != idx) return;

        // 주위에 이동할 수 있는 타일은 전부 자신의 자손으로 등록
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{y, x});

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            cnt[idx]++;

            for (int i = 0; i < 4; i++) {
                int nextY = curr[0] + dy[i];
                int nextX = curr[1] + dx[i];
                int nextIdx = nextY * M + nextX;

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M || map[nextY][nextX] == 1 || parent[nextIdx] == idx) continue;

                parent[nextIdx] = idx;
                deque.add(new int[]{nextY, nextX});
            }
        }
    }

    static int getCount(int y, int x) {

        int sum = 1;
        HashSet<Integer> parentSet = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            int nextIdx = nextY * M + nextX;

            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M || map[nextY][nextX] == 1) continue;

            int p = parent[nextIdx];
            if (parentSet.contains(p)) continue;

            parentSet.add(p);
            sum += cnt[p];
        }

        return sum;
    }
}