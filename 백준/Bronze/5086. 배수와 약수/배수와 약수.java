import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            if (num1 == 0 && num2 == 0) {
                return;
            }

            if (num1 > num2) {
                if (num1 % num2 == 0) {
                    System.out.println("multiple");
                } else {
                    System.out.println("neither");
                }
            } else {
                if (num2 % num1 == 0) {
                    System.out.println("factor");
                } else {
                    System.out.println("neither");
                }
            }
        }
    }
}