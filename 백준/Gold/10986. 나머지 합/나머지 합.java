import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sumArr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        long cnt = 0;

        long[] remainCntArr = new long[M];
        for (int i = 1; i <= N; i++) {
            int remain = (int) (sumArr[i] % M);

            if (remain == 0) {
                cnt++;
            }

            remainCntArr[remain]++;
        }

        for (int i = 0; i < M; i++) {
            cnt += ((remainCntArr[i] - 1) * (remainCntArr[i])) / 2;
        }

        System.out.println(cnt);
    }
}