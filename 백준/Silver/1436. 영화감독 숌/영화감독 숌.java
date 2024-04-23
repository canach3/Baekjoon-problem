import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = 0;
        int ans = 0;

        while (n != num) {
            ans++;

            String ansToStr = Integer.toString(ans);

            if (ansToStr.contains("666")) {
                num++;
            }
        }
        System.out.println(ans);
    }
}