import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();
        String result = "";

        while (n > 0) {
            if (n % b < 10) {
                result +=  n % b;
            } else {
                result += (char) (n % b + 55);
            }

            n = n / b;
        }

        for (int i = result.length() - 1; i >= 0; i--) {
            System.out.print(result.charAt(i));
        }

        sc.close();
    }
}
