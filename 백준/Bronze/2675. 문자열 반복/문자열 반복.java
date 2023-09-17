
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int rep = sc.nextInt();
            String input = sc.next();

            char[] result = new char[input.length()];
            input.getChars(0, input.length(), result, 0);

            for (char c : result) {
                for (int k = 0; k < rep; k++) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}