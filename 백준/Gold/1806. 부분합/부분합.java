import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        int min = Integer.MAX_VALUE;
        while (right <= N) {
            int sum = arr[right] - arr[left];

            if (sum >= S) {
                min = Math.min(min, right - left);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}