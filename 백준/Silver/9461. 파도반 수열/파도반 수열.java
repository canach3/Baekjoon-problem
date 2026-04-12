import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine().trim());

            long[] dp = new long[N < 5 ? 6 : N + 1];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;

            for (int i = 6; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.print(sb);
    }
}