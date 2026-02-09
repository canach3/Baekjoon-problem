import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine().trim());
            String[] arr = new String[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            if (N % 2 == 0) {
                int idx = 0;
                for (int i = 0; i < N / 2; i++) {
                    arr[idx] = st.nextToken();
                    idx += 2;
                }

                idx = 1;
                for (int i = N / 2; i < N; i++) {
                    arr[idx] = st.nextToken();
                    idx += 2;
                }

            } else {
                int idx = 0;
                for (int i = 0; i <= N / 2; i++) {
                    arr[idx] = st.nextToken();
                    idx += 2;
                }

                idx = 1;
                for (int i = N / 2; i < N - 1; i++) {
                    arr[idx] = st.nextToken();
                    idx += 2;
                }
            }

            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}