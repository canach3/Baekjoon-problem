import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] dp = new int[N + 1];

        Arrays.fill(dp, N + 1);
        dp[0] = 0;

        int[] coins = {2, 5};
        for (int i = 0; i <= N; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[N] == N + 1 ? -1 : dp[N]);
    }
}