import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] sumArr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + i;
        }

        int cnt = 1;
        int high = 1;
        int low = 0;

        while ((N > high) && (N > low)) {
            if (low >= high) {
                break;
            }

            if (sumArr[high] - sumArr[low] == N) {
                cnt++;
                high++;
            }

            if ((sumArr[high] - sumArr[low]) < N) {
                high++;
            }

            if ((sumArr[high] - sumArr[low]) > N) {
                low++;
            }
        }

        System.out.println(cnt);
    }
}