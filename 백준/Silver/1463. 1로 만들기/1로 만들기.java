import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        
        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        if (N <= 3) {
            System.out.println(1);
            return;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            if (i % 2 != 0 && i % 3 != 0) {
                dp[i] = dp[i - 1] + 1;
            } else if (i % 2 == 0 && i % 3 != 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
            } else if (i % 2 != 0 && i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, Math.min(dp[i / 2] + 1, dp[i / 3] + 1));
            }
        }

        System.out.println(dp[N]);
    }
}