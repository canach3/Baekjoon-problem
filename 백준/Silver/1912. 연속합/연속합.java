import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sumArr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        int max = Integer.MIN_VALUE;

        while (right <= N) {
            if (right == left) {
                right++;
                continue;
            }

            int sum = sumArr[right] - sumArr[left];

            max = Math.max(max, sum);

            if (sum < 0) {
                left++;
            } else {
                right++;
            }
        }

        System.out.println(max);
    }
}