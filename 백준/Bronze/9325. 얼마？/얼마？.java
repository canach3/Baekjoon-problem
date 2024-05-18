import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int carPrice = sc.nextInt();
            int optionCase = sc.nextInt();
            int sum = carPrice;

            for (int j = 0; j < optionCase; j++) {
                int optionNum = sc.nextInt();
                int optionPrice = sc.nextInt();
                sum += optionNum * optionPrice;
            }

            System.out.println(sum);
        }
    }
}