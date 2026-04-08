import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());

            boolean[][] possible = new boolean[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                possible[i][i] = true;
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                possible[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (possible[i][k] && possible[k][j]) {
                            possible[i][j] = true;
                        }
                    }
                }
            }

            int result = 0;
            for (int i = 1; i <= N; i++) {
                int cnt = 0;
                for (int j = 1; j <= N; j++) {
                    if (possible[i][j] || possible[j][i]) cnt++;
                }

                if (cnt >= N) result++;
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}