import java.io.*;
import java.util.*;

public class Solution {
    static char[][] map;
    static int min;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];

            for (int i = 0; i < N; i++) {
                String input = br.readLine().trim();
                map[i] = input.toCharArray();
            }

            int cnt = 0;

            // 맨 윗줄 처리
            for (int i = 0; i < M; i++) {
                if (map[0][i] != 'W') cnt++;
            }

            // 맨 아랫줄 처리
            for (int i = 0; i < M; i++) {
                if (map[N - 1][i] != 'R') cnt++;
            }

            min = N * M;
            DFS(cnt, 1, 1);

            sb.append(min).append("\n");
        }

        System.out.print(sb);
    }

    static void DFS(int cnt, int line, int color) { // 1:W 2:B 3:R
        // 마지막 줄인 경우
        if (line >= N - 2) {
            if (color == 1) {
                for (int i = 0; i < M; i++) {
                    if (map[line][i] != 'B') cnt++;;
                }
            }

            if (color == 2) {
                int BCnt = 0;
                int RCnt = 0;
                for (int i = 0; i < M; i++) {
                    if (map[line][i] != 'B') BCnt++;;
                    if (map[line][i] != 'R') RCnt++;;
                }

                cnt += Math.min(BCnt, RCnt);
            }

            if (color == 3) {
                for (int i = 0; i < M; i++) {
                    if (map[line][i] != 'R') cnt++;;
                }
            }

            min = Math.min(min, cnt);
            return;
        }

        // 마지막줄이 아닌 경우
        if (color == 1) {
            int WCnt = 0;
            for (int i = 0; i < M; i++) {
                if (map[line][i] != 'W') WCnt++;;
            }

            DFS(cnt + WCnt, line + 1, 1);

            int BCnt = 0;
            for (int i = 0; i < M; i++) {
                if (map[line][i] != 'B') BCnt++;;
            }

            DFS(cnt + BCnt, line + 1, 2);
        }

        if (color == 2) {
            int BCnt = 0;
            for (int i = 0; i < M; i++) {
                if (map[line][i] != 'B') BCnt++;;
            }

            DFS(cnt + BCnt, line + 1, 2);

            int RCnt = 0;
            for (int i = 0; i < M; i++) {
                if (map[line][i] != 'R') RCnt++;;
            }

            DFS(cnt + RCnt, line + 1, 3);
        }

        if (color == 3) {
            int RCnt = 0;
            for (int i = 0; i < M; i++) {
                if (map[line][i] != 'R') RCnt++;;
            }

            DFS(cnt + RCnt, line + 1, 3);
        }
    }
}