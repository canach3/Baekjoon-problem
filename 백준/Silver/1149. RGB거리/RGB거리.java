import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] RGB = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        dp[0][0] = RGB[0][0];
        dp[0][1] = RGB[0][1];
        dp[0][2] = RGB[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + RGB[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + RGB[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + RGB[i][2];
        }

        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }
}