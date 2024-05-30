import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] fibo = new int[46];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= 45; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibo[n]);
    }
}