import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lectures = new int[N];

        int sum = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];

            if (lectures[i] > max) {
                max = lectures[i];
            }
        }

        int left = max;
        int right = sum;
        int result = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int cnt = 1;
            sum = 0;

            for (int i = 0; i < N ; i++) {
                sum += lectures[i];
                
                if (sum > middle) {
                    cnt++;
                    sum = lectures[i];
                } 
            }

            if (cnt <= M) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        System.out.print(result);
    }
}