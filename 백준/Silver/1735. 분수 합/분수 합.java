import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int deNum1 = sc.nextInt();
        int num2 = sc.nextInt();
        int deNum2 = sc.nextInt();

        int deNumResult = deNum1 * deNum2;
        int numResult = (num1 * deNum2) + (num2 * deNum1);

        int gcd = gcd(deNumResult, numResult);

        deNumResult /= gcd;
        numResult /= gcd;

        System.out.println(numResult + " " + deNumResult);
    }

   static int gcd(int a, int b) {
       if (b == 0) {
           return a;
       } else {
           return gcd(b, a % b);
       }
   }
   static int lcm(int a, int b) {
        return a * b / gcd(a, b);
   }
}