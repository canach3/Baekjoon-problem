import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] cards;
    static int max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        DFS(0, 0, 0);

        System.out.println(max);
    }

    static void DFS(int idx, int cnt, int sum) {
        if (cnt == 3) {
            if (sum <= M) {
                max = Math.max(max, sum);
            }

            return;
        }

        if (idx >= N) return;

        DFS(idx + 1, cnt, sum);
        DFS(idx + 1, cnt + 1, sum + cards[idx]);
    }
}