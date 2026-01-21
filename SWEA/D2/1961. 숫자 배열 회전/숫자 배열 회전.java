import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                // 90도
                for (int j = 0; j < N; j++) {
                    sb.append(map[N - 1 - j][i]);
                }
                sb.append(" ");

                // 180도
                for (int j = 0; j < N; j++) {
                    sb.append(map[N - 1 - i][N - 1 - j]);
                }
                sb.append(" ");

                // 270도
                for (int j = 0; j < N; j++) {
                    sb.append(map[j][N - 1 - i]);
                }
                sb.append("\n");
            }

            System.out.print("#" + testCase + " " + "\n" + sb);
        }
    }
}