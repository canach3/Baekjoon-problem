import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] fiboArr = new long[91];

        fiboArr[0] = 0;
        fiboArr[1] = 1;

        for (int i = 2; i <= 90; i++) {
            fiboArr[i] = fiboArr[i-1] + fiboArr[i-2];
        }

        System.out.println(fiboArr[n]);
    }
}