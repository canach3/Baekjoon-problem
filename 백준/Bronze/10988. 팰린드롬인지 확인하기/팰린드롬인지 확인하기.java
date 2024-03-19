import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char frontCs;
        char backC;

        for (int i = 0, j = s.length() - 1; i < s.length() / 2 && j >= (s.length() + 1) / 2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}