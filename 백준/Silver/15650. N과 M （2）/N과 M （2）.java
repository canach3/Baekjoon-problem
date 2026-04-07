import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int N;
    static int M;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        check = new boolean[N + 1];

        sequence(1, new int[M + 1]);

        System.out.print(sb);
    }

    static void sequence(int idx, int[] arr) {
        if (idx > M) {
            for (int i = 1; i <= M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = arr[idx - 1] + 1; i <= N; i++) {
            if (check[i]) continue;

            check[i] = true;
            arr[idx] = i;
            sequence(idx + 1, arr);
            check[i] = false;
        }
    }
}