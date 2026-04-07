import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        int[] arr = new int[M + 1];
        arr[0] = 1;
        sequence(1, arr);

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

        for (int i = arr[idx - 1]; i <= N; i++) {
            arr[idx] = i;
            sequence(idx + 1, arr);
        }
    }
}