import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cntPrime = 0;
        int times = sc.nextInt();

        for (int i = 0; i < times; i++) {
            int cnt = 0;
            int num = sc.nextInt();

            if (num == 1) {
                continue;
            } else {
                for (int j = 1; j <= num; j++) {
                    if (num % j == 0) {
                        cnt++;
                    }
                }
            }

            if (cnt == 2) {
                cntPrime++;
            }
        }

        System.out.println(cntPrime);
    }
}