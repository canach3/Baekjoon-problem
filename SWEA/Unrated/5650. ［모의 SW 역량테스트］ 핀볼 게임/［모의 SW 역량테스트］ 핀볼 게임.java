import java.io.*;
import java.util.*;

public class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static int maxScore;
    static List<Wormhole>[] wormholes;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            maxScore = 0;
            wormholes = new List[11];

            int N = Integer.parseInt(br.readLine().trim());

            map = new int[N + 2][N + 2];
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    map[i][j] = -2;
                }
            }

            for (int i = 6; i <= 10; i++) {
                wormholes[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] >= 6 && map[i][j] <= 10) {
                        wormholes[map[i][j]].add(new Wormhole(j, i));
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == 0) {
                        game(i, j, 0);
                        game(i, j, 1);
                        game(i, j, 2);
                        game(i, j, 3);
                    }
                }
            }

            sb.append("#").append(testCase).append(" ").append(maxScore).append("\n");
        }

        System.out.print(sb);
    }

    static void game(int y, int x, int direction) {
        int startX = x;
        int startY = y;
        int score = 0;

        while(true) {
            x += dx[direction];
            y += dy[direction];

            // 내가 블랙홀인 경우 || 내가 출발위치인 경우 종료
            if (map[y][x] == -1 || (x == startX && y == startY)) break;

            // 내가 웜홀인 경우(순간이동)
            if (map[y][x] >= 6 && map[y][x] <= 10) {
                int holeNum = map[y][x];
                Wormhole w1 = wormholes[holeNum].get(0);
                Wormhole w2 = wormholes[holeNum].get(1);

                if (y == w1.y && x == w1.x) {
                    y = w2.y;
                    x = w2.x;
                } else {
                    y = w1.y;
                    x = w1.x;
                }
            }

            // 내가 벽인 경우(점수)
            else if (map[y][x] == -2) {
                switch (direction) {
                    case 0:
                        direction = 1;
                        break;
                    case 1:
                        direction = 0;
                        break;
                    case 2:
                        direction = 3;
                        break;
                    case 3:
                        direction = 2;
                        break;
                }
                score++;
            }

            // 내가 블록인 경우(점수)
            else if (map[y][x] >= 1 && map[y][x] <= 5) {
                int blockType = map[y][x];
                switch (blockType) {
                    case 1:
                        if (direction == 0) direction = 1;
                        else if (direction == 1) direction = 3;
                        else if (direction == 2) direction = 0;
                        else if (direction == 3) direction = 2;
                        break;
                    case 2:
                        if (direction == 0) direction = 3;
                        else if (direction == 1) direction = 0;
                        else if (direction == 2) direction = 1;
                        else if (direction == 3) direction = 2;
                        break;
                    case 3:
                        if (direction == 0) direction = 2;
                        else if (direction == 1) direction = 0;
                        else if (direction == 2) direction = 3;
                        else if (direction == 3) direction = 1;
                        break;
                    case 4:
                        if (direction == 0) direction = 1;
                        else if (direction == 1) direction = 2;
                        else if (direction == 2) direction = 3;
                        else if (direction == 3) direction = 0;
                        break;
                    case 5:
                        if (direction == 0) direction = 1;
                        else if (direction == 1) direction = 0;
                        else if (direction == 2) direction = 3;
                        else if (direction == 3) direction = 2;
                        break;
                }

                score++;
            }
        }

        if (score > maxScore) maxScore = score;
    }

    static class Wormhole {
        int x;
        int y;

        Wormhole(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}