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
            int Q = Integer.parseInt(st.nextToken());

            int[] arr = new int[N + 1];

            for (int i = 1; i <= Q; i++) {
                st = new StringTokenizer(br.readLine());
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());

                for (int j = L; j <= R; j++) {
                    arr[j] = i;
                }
            }

            for (int i = 1; i <= N; i++) {
                sb.append(arr[i]).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}