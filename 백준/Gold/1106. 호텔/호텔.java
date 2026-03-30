import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); // C : 목표 고객 수(이상)
        int N = Integer.parseInt(st.nextToken()); // N : 방법 수

        int[][] cost = new int[N][2];
        int maxUnit = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());

            maxUnit = Math.max(maxUnit, cost[i][1]);
        }

        int[] dp = new int[C + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i <= Math.min(C, maxUnit); i++) {
            for (int j = 0; j < N; j++) {
                if (i - cost[j][1] < 0) {
                    dp[i] = Math.min(dp[i], cost[j][0]);
                } else {
                    dp[i] = Math.min(dp[i], dp[i - cost[j][1]] + cost[j][0]);
                }
            }
        }

        for (int i = 1; i <= C; i++) {
            for (int j = 0; j < N; j++) {
                if (cost[j][1] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - cost[j][1]] + cost[j][0]);
                }
            }
        }

        System.out.println(dp[C]);
    }
}