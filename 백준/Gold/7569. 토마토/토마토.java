import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로 칸
        int N = Integer.parseInt(st.nextToken()); // 세로 칸
        int H = Integer.parseInt(st.nextToken()); // 상자 수

        int[][][] tomatoes = new int[H][N][M];
        Deque<int[]> deque = new ArrayDeque<>();

        int ripeCnt = 0;
        int hole = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int tomato =Integer.parseInt(st.nextToken());
                    tomatoes[i][j][k] = tomato;

                    if (tomato == 1) {
                        deque.addLast(new int[]{i, j, k, 0});
                        ripeCnt++;
                    } else if (tomato == -1) hole++;
                }
            }
        }

        // 처음부터 다 익은 경우
        if (deque.size() == M * N * H) {
            System.out.println(0);
            return;
        }

        int max = 0;
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int currZ = curr[0];
            int currY = curr[1];
            int currX = curr[2];
            int time = curr[3];

            for (int i = 0; i < 6; i++) {
                int nextZ = currZ + dz[i];
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];

                if (nextZ < 0 || nextZ >= H || nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) continue;

                if (tomatoes[nextZ][nextY][nextX] == 0) {
                    ripeCnt++;
                    tomatoes[nextZ][nextY][nextX] = 1;
                    deque.add(new int[]{nextZ, nextY, nextX, time + 1});
                }
            }

            max = Math.max(max, time);
        }

        if (ripeCnt != H*N*M - hole) {
            System.out.println(-1);
            return;
        }

        System.out.println(max);
    }
}