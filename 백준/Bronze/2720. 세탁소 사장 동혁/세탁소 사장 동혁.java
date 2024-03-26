import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int times = sc.nextInt();

        int quarter;
        int dime;
        int nickel;
        int penny;

        for (int i = 0; i < times; i++) {
            int changes = sc.nextInt();

            quarter = changes / 25;
            changes %= 25;

            dime = changes / 10;
            changes %= 10;

            nickel = changes / 5;

            penny = changes % 5;

            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }
    }
}