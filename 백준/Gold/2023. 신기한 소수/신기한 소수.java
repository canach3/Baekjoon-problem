import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        N = sc.nextInt();

        for (int i = 2; i <= 9; i++) {
            int digit = 1;

            if (i == 2 || i == 3 || i == 5 || i == 7) {
                DFS(i, digit);
            }
        }

        System.out.println(sb);
    }

    static void DFS(int i, int digit) {
        if (digit >= N) {
            sb.append(i).append("\n");
            return;
        }

        digit++;

        for (int j = 1; j <= 9; j++) {
            int num = i * 10 + j;

            if(isPrime(num)) {
                DFS(num, digit);
            }
        }
    }

    static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}