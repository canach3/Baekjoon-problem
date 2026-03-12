import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static boolean[][] tunnel = {
        // 현재 터널 0 -> 이동 불가
        {}, {}, {}, {},

        // 현재 터널 1
        {false, true, true, false, false, true, true, false}, // 상 - 가능한 터널
        {false, true, true, false, true, false, false, true}, // 하 - 가능한 터널
        {false, true, false, true, true, true, false, false}, // 좌 - 가능한 터널
        {false, true, false, true, false, false, true, true}, // 우 - 가능한 터널

        // 현재 터널 2
        {false, true, true, false, false, true, true, false}, // 상 - 가능한 터널
        {false, true, true, false, true, false, false, true}, // 하 - 가능한 터널
        {false, false, false, false, false, false, false, false}, // 좌 - 가능한 터널
        {false, false, false, false, false, false, false, false}, // 우 - 가능한 터널

        // 현재 터널 3
        {false, false, false, false, false, false, false, false}, // 상 - 가능한 터널
        {false, false, false, false, false, false, false, false}, // 하 - 가능한 터널
        {false, true, false, true, true, true, false, false}, // 좌 - 가능한 터널
        {false, true, false, true, false, false, true, true}, // 우 - 가능한 터널

        // 현재 터널 4
        {false, true, true, false, false, true, true, false}, // 상 - 가능한 터널
        {false, false, false, false, false, false, false, false}, // 하 - 가능한 터널
        {false, false, false, false, false, false, false, false}, // 좌 - 가능한 터널
        {false, true, false, true, false, false, true, true}, // 우 - 가능한 터널

        // 현재 터널 5
        {false, false, false, false, false, false, false, false}, // 상 - 가능한 터널
        {false, true, true, false, true, false, false, true}, // 하 - 가능한 터널
        {false, false, false, false, false, false, false, false}, // 좌 - 가능한 터널
        {false, true, false, true, false, false, true, true}, // 우 - 가능한 터널

        // 현재 터널 6
        {false, false, false, false, false, false, false, false}, // 상 - 가능한 터널
        {false, true, true, false, true, false, false, true}, // 하 - 가능한 터널
        {false, true, false, true, true, true, false, false}, // 좌 - 가능한 터널
        {false, false, false, false, false, false, false, false}, // 우 - 가능한 터널

        // 현재 터널 7
        {false, true, true, false, false, true, true, false}, // 상 - 가능한 터널
        {false, false, false, false, false, false, false, false}, // 하 - 가능한 터널
        {false, true, false, true, true, true, false, false}, // 좌 - 가능한 터널
        {false, false, false, false, false, false, false, false}, // 우 - 가능한 터널
    };

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            int startTunnel = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if(i == R && j == C) startTunnel = map[i][j];
                }
            }

            Deque<int[]> deque = new ArrayDeque<>();
            deque.addLast(new int[]{R, C, startTunnel, 1});
            visited[R][C] = true;

            int cnt = 1;
            while (!deque.isEmpty() && deque.peekFirst()[3] < L) {
                int[] tile = deque.pollFirst();
                int y = tile[0];
                int x = tile[1];
                int currTunnel = tile[2];
                int time = tile[3];

                for (int i = 0; i < 4; i++) {
                    int nextY = y + dy[i];
                    int nextX = x + dx[i];

                    // 경계 체크
                    if (nextY == -1 || nextY == N || nextX == -1 || nextX == M) continue;
                    // 방문했는지, 터널인지 체크
                    if (visited[nextY][nextX] || map[nextY][nextX] == 0) continue;

                    // 다음 터널로 이동 가능한지 체크
                    int nextTunnel = map[nextY][nextX];
                    if (tunnel[currTunnel * 4 + i][nextTunnel]) {
                        visited[nextY][nextX] = true;
                        deque.addLast(new int[] {nextY, nextX, nextTunnel, time + 1});
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}