import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int left = 0;
        int max = 0;

        for (int i = 0; i < 4; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();

            left += in - out;

            if (left >= max) {
                max = left;
            }
        }

        System.out.println(max);
    }
}