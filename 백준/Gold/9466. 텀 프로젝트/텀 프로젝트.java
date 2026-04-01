import java.io.*;
import java.util.*;

public class Main {
    static boolean[] discovered;
    static boolean[] finished;
    static int[] next;
    static int cnt;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine().trim());

            discovered = new boolean[N + 1];
            finished = new boolean[N + 1];
            next = new int[N + 1];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                next[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!discovered[i]) DFS(i);
            }

            sb.append(N - cnt).append("\n");
        }

        System.out.print(sb);
    }

    static void DFS(int curr) {
        discovered[curr] = true;

        if (!discovered[next[curr]]) DFS(next[curr]);
        else if (!finished[next[curr]]) {
            int nextNum = next[curr];
            cnt++;

            while (nextNum != curr) {
                cnt++;
                nextNum = next[nextNum];
            }
        }

        finished[curr] = true;
    }
}