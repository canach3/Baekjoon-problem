import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int totalPrice = sc.nextInt();
        int kindOf = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < kindOf; i++) {
            int price = sc.nextInt();
            int n = sc.nextInt();

            sum += price * n;
        }
        if (sum == totalPrice) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}