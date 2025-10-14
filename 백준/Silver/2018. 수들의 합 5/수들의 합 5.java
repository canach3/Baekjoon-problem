import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] sumArr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            if(i == 0) {
                sumArr[i] = 0;
            } else {
                sumArr[i] = sumArr[i-1] + i;
            }
        }

        int left = 0;
        int right = 1;
        int cnt = 0;

        while(left < right && right <= N) {
            int result = sumArr[right] - sumArr[left];

            if (result == N) {
                cnt++;
                right++;
                continue;
            }

            if (result < N) {
                right++;
                continue;
            }

            if (result > N) {
                left++;
                continue;
            }
        }

        System.out.println(cnt);
    }
}