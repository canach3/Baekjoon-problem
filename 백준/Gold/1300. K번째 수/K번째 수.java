import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int low = 1;
        int high = K;
        int result = 0;
        
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, middle / i);
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