import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] tree = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (N == 1) {
            System.out.println(tree[0][0]);
            return;
        }

        dp[0][0] = tree[0][0];
        dp[1][0] = tree[0][0] + tree[1][0];
        dp[1][1] = tree[0][0] + tree[1][1];

        for (int i = 2; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + tree[i][0];

            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tree[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }

        System.out.println(max);
    }
}