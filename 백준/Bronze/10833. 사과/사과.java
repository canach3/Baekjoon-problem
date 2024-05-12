import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int left = 0;
        for (int i = 0; i < n; i++) {
            int studentN = sc.nextInt();
            int appleN = sc.nextInt();

            left += appleN % studentN;
        }

        System.out.println(left);
    }
}