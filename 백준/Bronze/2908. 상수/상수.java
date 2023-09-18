
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.next();
        String num2 = sc.next();

        String sRevNum1 = "";
        String sRevNum2 = "";
        String temp;

        for (int i = 2; i >= 0; i--) {
            temp = num1.substring(i, i+1);
            sRevNum1 += temp;
            temp = num2.substring(i, i+1);
            sRevNum2 += temp;
        }
        int iRevNum1 = Integer.parseInt(sRevNum1);
        int iRevNum2 = Integer.parseInt(sRevNum2);

        System.out.println(Math.max(iRevNum1, iRevNum2));

        sc.close();
    }
}