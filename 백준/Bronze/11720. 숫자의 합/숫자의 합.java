
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String number = sc.nextLine();
        sc.close();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += number.charAt(i) - 48;
        }
        System.out.println(sum);
    }
}