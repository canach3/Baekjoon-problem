import java.io.*;
import java.util.*;

class Solution {
    static int[] arr;
    static int N;
    static int K;
    static int cnt;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            DFS(0, 0);

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static void DFS(int sum, int idx) {
        if (sum + arr[idx] == K) cnt++;

        if (idx == N - 1) return;

        DFS(sum, idx + 1);
        DFS(sum + arr[idx], idx + 1);
    }
}