import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        if (N == 1) {
            System.out.println(9);
            return;
        }

        int[][] dp = new int[N + 1][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            // 0, 9 처리
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];

            // 1 ~ 8 처리
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        long sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum % 1000000000);
    }
}