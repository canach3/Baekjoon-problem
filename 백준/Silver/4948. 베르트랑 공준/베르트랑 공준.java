import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }

            int cnt = 0;
            for (int i = n + 1; i <= (2 * n); i++) {
                if (isPrime(i)) {
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