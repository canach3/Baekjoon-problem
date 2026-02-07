import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int sum;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String input = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j] = input.charAt(j) - '0';
                }
            }

            sum = 0;
            DFS(N / 2, N / 2);

            sb.append("#").append(testCase).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }

    static void DFS(int y, int x) {
        visited[y][x] = true;
        sum += map[y][x];

        if (Math.abs(N/2 - y) + Math.abs(N/2 - x) >= N / 2) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (!visited[y + dy[i]][x + dx[i]]) {
                DFS(y + dy[i], x + dx[i]);
            }
        }
    }
}