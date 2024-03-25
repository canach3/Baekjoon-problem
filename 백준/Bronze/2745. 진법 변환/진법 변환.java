import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int b = sc.nextInt();
        long result = 0;
        int num;

        for (int i = 0; i < n.length(); i++) {
            if ((n.charAt(i) - '0') >= 0 && (n.charAt(i) - '0') <= 9) {
                num = n.charAt(i) - '0';
            } else {
                num = n.charAt(i) - 55;
            }

            result += num * Math.pow(b, n.length() - 1 - i);
        }
        System.out.println(result);
    }
}
