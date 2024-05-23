import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int d1 = sc.nextInt();
            int d2 = sc.nextInt();
            int sum = d1 + d2;

            System.out.println("Case " + (i+1) + ": " + sum);
        }
    }
}