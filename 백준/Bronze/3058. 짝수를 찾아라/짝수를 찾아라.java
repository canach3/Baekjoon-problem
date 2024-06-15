import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int sum = 0;
            int minN = 100;

            for (int j = 0; j < 7; j++) {

                int num = sc.nextInt();

                if (num % 2 == 0) {
                    sum += num;

                    if (num <= minN) {
                        minN = num;
                    }
                }
            }

            System.out.println(sum + " " + minN);
        }
    }
}