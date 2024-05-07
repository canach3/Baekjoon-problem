import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int GCD = 0;
        int LCM = n1 * n2;

        for (int i = 1; i <= Math.min(n1, n2); i++) {
            if ((n1 % i == 0) && (n2 % i == 0)) {
                GCD = i;
            }
        }

        for (int i = n1 * n2; i >= Math.max(n1, n2); i--) {
            if ((i % n1 == 0) && (i % n2 == 0)) {
                LCM = i;
            }
        }

        System.out.println(GCD + "\n" + LCM);
    }
}