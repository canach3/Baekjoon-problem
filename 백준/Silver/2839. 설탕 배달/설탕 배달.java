import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sugar = sc.nextInt();
        int ans = 0;

        while (sugar >= 0) {
            if (sugar % 5 == 0) {
                ans += (sugar / 5);
                System.out.println(ans);

                return;
            } else {
                sugar -= 3;
                ans++;
            }
        }

        System.out.println(-1);
    }
}