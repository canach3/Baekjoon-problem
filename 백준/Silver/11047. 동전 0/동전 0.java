import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coinArr = new int[N];
        for (int i = 0; i < N; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int remain = K;

        for (int i = N-1; i >= 0; i--) {
            cnt += remain / coinArr[i];
            remain %= coinArr[i];

            if (remain == 0) {
                break;
            }
        }

        System.out.println(cnt);
    }
}