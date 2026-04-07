import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    static int min;
    static boolean[] isStart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        isStart = new boolean[N + 1];
        DFS(1, 0);

        System.out.println(min);
    }

    static void DFS(int idx, int cnt) {
        if (idx == N + 1) return;

        if (cnt == N / 2) {
            int sumStart = 0;
            int sumLink = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (isStart[i] && isStart[j]) sumStart += map[i][j];
                    if (!isStart[i] && !isStart[j]) sumLink += map[i][j];
                }
            }

            min = Math.min(min, Math.abs(sumStart - sumLink));
            return;
        }

        isStart[idx] = true;
        DFS(idx + 1, cnt + 1);

        isStart[idx] = false;
        DFS(idx + 1, cnt);
    }
}