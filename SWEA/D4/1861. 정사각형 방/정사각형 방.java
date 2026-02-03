import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map;
    static int max;
    static int room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N + 2][N + 2];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;
            room = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int cnt = DFS(i, j);

                    if (cnt >= max) {
                        if (cnt == max) {
                            room = Math.min(room, map[i][j]);
                        } else {
                            room = map[i][j];
                        }

                        max = cnt;
                    }
                }
            }

            System.out.println("#" + testCase + " " + room + " " + max);
        }
    }

    static int DFS(int y, int x) {
        if (map[y - 1][x] == map[y][x] + 1) {
            return DFS(y - 1, x) + 1;
        }

        if (map[y + 1][x] == map[y][x] + 1) {
            return DFS(y + 1, x) + 1;
        }

        if (map[y][x - 1] == map[y][x] + 1) {
            return DFS(y, x - 1) + 1;
        }

        if (map[y][x + 1] == map[y][x] + 1) {
            return DFS(y, x + 1) + 1;
        }
        return 1;
    }
}