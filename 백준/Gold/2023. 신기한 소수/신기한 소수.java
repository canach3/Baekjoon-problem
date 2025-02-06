import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int num, int digit) {
        if (digit == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }

            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, digit + 1);
            }
        }
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}