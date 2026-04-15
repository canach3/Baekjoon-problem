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

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] up = new int[N + 1];
        Arrays.fill(up, 1);

        int[] down = new int[N + 1];
        Arrays.fill(down, 1);

        int[] dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    up[i] = Math.max(up[i], up[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 1; i--) {
            for (int j = N; j > i; j--) {
                if (arr[i] > arr[j]) {
                    down[i] = Math.max(down[i], down[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = up[i] + down[i] - 1;
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}