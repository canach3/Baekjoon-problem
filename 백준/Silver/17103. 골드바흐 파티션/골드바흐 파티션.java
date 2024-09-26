import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] primeArr = new boolean[1000001];
        for (int i = 0; i < primeArr.length; i++) {
            if (isPrime(i)) {
                primeArr[i] = true;
            }
        }

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int cnt = 0;

            for (int j = 2; j <= n/2; j++) {
                if (primeArr[j] && primeArr[n - j]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}