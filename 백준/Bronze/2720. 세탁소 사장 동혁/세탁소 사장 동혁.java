
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            double change = sc.nextInt();

            quarter = (int)(change / 25);
            if (quarter != 0) {
                change = change % (quarter * 25);
            }

            dime = (int)(change / 10);
            if (dime != 0) {
                change = change % (dime * 10);
            }

            nickel = (int)(change / 5);
            if (nickel != 0) {
                change = change % (nickel * 5);
            }

            penny = (int)change;

            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }
    }
}
