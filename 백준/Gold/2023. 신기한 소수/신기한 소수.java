import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        System.out.println(sb);
    }

    static void DFS(int num, int digit) {
        if (digit > N) {
            return;
        }

        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            if (digit == N) {
                sb.append(num).append("\n");
            }

            for (int i = 1; i <= 9; i++) {
                DFS((num * 10) + i, digit + 1);
            }
        }
    }
}