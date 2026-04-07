import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine().trim());
            int[][] map = new int[N + 2][N + 2];
            int[][] cost = new int[N + 2][N + 2];

            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    map[i][j] = -1;
                }
            }

            for (int i = 1; i <= N; i++) {
                String input = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j + 1] = input.charAt(j) - '0';
                    cost[i][j + 1] = Integer.MAX_VALUE;
                }
            }
            cost[1][1] = map[1][1];

            Deque<int[]> deque = new ArrayDeque<>();
            deque.addLast(new int[] {1, 1});

            while (!deque.isEmpty()) {
                int[] current = deque.pollFirst();
                int y = current[0];
                int x = current[1];

                for (int i = 0; i < 4; i++) {
                    int nextY = y + dy[i];
                    int nextX = x + dx[i];

                    // 경계인 경우 제외
                    if (map[nextY][nextX] == -1) continue;

                    // 더 적은 비용으로 도착할 수 있으면 갱신 후 넣기
                    if (cost[nextY][nextX] > cost[y][x] + map[nextY][nextX]) {
                        cost[nextY][nextX] = cost[y][x] + map[nextY][nextX];
                        deque.addLast(new int[] {nextY, nextX});
                    }
                }
            }

            sb.append(cost[N][N]).append("\n");
        }

        System.out.print(sb);
    }
}