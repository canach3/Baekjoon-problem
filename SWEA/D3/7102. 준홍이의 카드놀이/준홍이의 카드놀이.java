import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] counts = new int[N + M + 1];

            int max = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    counts[i + j]++;
                    if (counts[i + j] > max) {
                        max = counts[i + j];
                    }
                }
            }

            for (int i = 0; i < N + M + 1; i++) {
                if (counts[i] == max) {
                    sb.append(i).append(" ");
                }
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}