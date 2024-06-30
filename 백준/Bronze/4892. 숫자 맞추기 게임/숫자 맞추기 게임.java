import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 1;
        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                return;
            }

            if (n % 2 == 0) {
                System.out.println(i + ". even " + n / 2);
            } else {
                System.out.println(i + ". odd " + ((n-1) / 2));
            }

            i++;
        }
    }
}