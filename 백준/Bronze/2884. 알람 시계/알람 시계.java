
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();

        if (m >= 45) {
            m -= 45;
        } else {
            if (h == 0) {
                m += 15;
                h = 23;
            } else {
                m += 15;
                h -= 1;
            }
        }
        System.out.println(h + " " + m);
    }
}
