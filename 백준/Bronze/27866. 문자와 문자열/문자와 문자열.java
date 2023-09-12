import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();

        System.out.println(s.substring(n - 1,n));

    }
}