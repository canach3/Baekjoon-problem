import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long low = 1;
        long high = K;
        long result = 0;

        while (low <= high) {
            long middle = low + (high - low) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(middle / i, N);
            }

            if (cnt < K) {
                low = middle + 1;
            }

            if (cnt >= K) {
                high = middle - 1;
                result = middle;
            }
        }

        System.out.println(result);
    }
}