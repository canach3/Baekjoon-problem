import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            double result = sc.nextDouble();
            String ops = sc.nextLine();

            for (int j = 0; j < ops.length(); j++) {
                if (ops.charAt(j) == '@') {
                    result *= 3;
                } else if (ops.charAt(j) == '%') {
                    result += 5;
                } else if (ops.charAt(j) == '#') {
                    result -= 7;
                }
            }

            System.out.printf("%.2f", result);
            System.out.println();
        }
    }
}