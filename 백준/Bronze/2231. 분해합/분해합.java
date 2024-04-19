import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       int num = sc.nextInt();

        for (int i = 1; i < num; i++) {

            int sum = i;
            int tmp = i;

            while(tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if (sum == num) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}