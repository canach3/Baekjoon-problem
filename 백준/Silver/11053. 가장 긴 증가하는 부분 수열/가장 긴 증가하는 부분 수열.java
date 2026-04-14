import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        if (N == 1) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        dp[1] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            int max = 1;
            for (int j = 1; j < i; j++) {
               if (arr[i] > arr[j]) {
                   max = Math.max(max, dp[j] + 1);
               }
            }

            dp[i] = max;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}