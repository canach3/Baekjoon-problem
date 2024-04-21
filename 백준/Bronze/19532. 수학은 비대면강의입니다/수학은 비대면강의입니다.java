import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        int x = -1000;
        int y = -1000;

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if ((i * a + b * j == c) && (i * d + e * j == f)) {
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}