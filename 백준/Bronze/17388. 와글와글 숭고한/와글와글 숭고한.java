import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int k = sc.nextInt();
        int h = sc.nextInt();

        if (s + k + h >= 100) {
            System.out.println("OK");
        } else {
            if (Math.min(s, Math.min(k, h)) == s) {
                System.out.println("Soongsil");
            } else if (Math.min(s, Math.min(k, h)) == k) {
                System.out.println("Korea");
            } else {
                System.out.println("Hanyang");
            }
        }
    }
}