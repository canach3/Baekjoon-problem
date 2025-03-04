import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        long left = 1;
        long right = K;
        long result = 0;

        while (left <= right) {
            long middle = (left + right) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(middle / i, N);
            }

            if (cnt < K) {
                left = middle + 1;
            } else {
                result = middle;
                right = middle - 1;
            }
        }

        System.out.println(result);
    }
}