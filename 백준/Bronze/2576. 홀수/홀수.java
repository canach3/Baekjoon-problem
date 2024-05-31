import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int minN = 100;

        for (int i = 0; i < 7; i++) {
            int n = sc.nextInt();

            if (n % 2 == 1) {
                sum += n;

                if (n <= minN) {
                    minN = n;
                }
            }
        }

        if (minN == 100) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(minN);
    }
}