import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] cnt1 = new int[H + 1];
        int[] cnt2 = new int[H + 1];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                cnt1[Integer.parseInt(br.readLine().trim())]++;
            } else {
                cnt2[H - Integer.parseInt(br.readLine().trim()) + 1]++;

            }
        }

        for (int i = H - 1; i >= 1; i--) {
            cnt1[i] += cnt1[i + 1];
        }

        for (int i = 2; i <= H; i++) {
            cnt2[i] += cnt2[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            int totalCnt = cnt1[i] + cnt2[i];

            if (totalCnt < min) {
                min = totalCnt;
                cnt = 1;
            } else if (totalCnt == min) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }
}