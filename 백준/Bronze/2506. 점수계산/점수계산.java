import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;
        int plus = 0;
        for (int i = 0; i < n; i++) {
            int answer = sc.nextInt();

            if (answer == 0) {
                plus = 0;
            } else {
                sum += ++plus;
            }
        }

        System.out.println(sum);
    }
}