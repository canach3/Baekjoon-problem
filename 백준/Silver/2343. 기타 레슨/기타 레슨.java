import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lectureArr = new int[N];
        int max = 0;
        int total = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectureArr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lectureArr[i]);
            total += lectureArr[i];
        }

        int left = max;
        int right = total;
        int result = total;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            int cnt = 1;

            for (int i = 0; i < N; i++) {
                if (sum + lectureArr[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += lectureArr[i];
            }

            if (cnt > M) {
                left = mid + 1;
            }

            if (cnt <= M) {
                result = mid;
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}