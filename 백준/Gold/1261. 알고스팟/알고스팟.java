import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] dist;
    static int[][] map;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 2][M + 2];
        for (int i = 0; i < N + 2; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = input.charAt(j) - '0';
            }
        }

        dist = new int[N + 2][M + 2];
        for (int i = 0; i < N + 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[1][1] = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{1, 1, 0});

        while (!deque.isEmpty()) {
            int[] tmp = deque.pollFirst();
            int currY = tmp[0];
            int currX = tmp[1];
            int cost = tmp[2];

            for (int i = 0; i < 4; i++) {
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];

                if (map[nextY][nextX] == -1) continue;

                int newCost = cost;
                if (map[nextY][nextX] == 1) newCost++;

                if (newCost < dist[nextY][nextX]) {
                    dist[nextY][nextX] = newCost;
                    deque.addLast(new int[] {nextY, nextX, newCost});
                }
            }
        }

        System.out.println(dist[N][M]);
    }
}