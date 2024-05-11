import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int i = 0;
        while (i < n) {
            n -= i;
            i++;
        }

        if (i % 2 == 0) {
            System.out.println(n + "/" + (i + 1 - n));
        } else {
            System.out.println((i + 1 - n) + "/" + n);
        }
    }
}