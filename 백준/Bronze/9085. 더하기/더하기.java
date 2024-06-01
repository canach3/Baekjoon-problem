import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();
            int sum = 0;

            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                sum += num;
            }

            System.out.println(sum);
        }
    }
}