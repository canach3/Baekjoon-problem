import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            int numerator = sc.nextInt();
            int denominator = sc.nextInt();

            if (denominator == 0 && numerator == 0) {
                break;
            }

            int quotient = numerator / denominator;
            int remainder = numerator % denominator;

            System.out.println(quotient + " " + remainder + " / " + denominator);
        }
    }
}