import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();

        System.out.println(lcm(a, b));
    }

   static long gcd(long a, long b) {
       if (b == 0) {
           return a;
       } else {
           return gcd(b, a % b);
       }
   }
   static long lcm(long a, long b) {
        return a * b / gcd(a, b);
   }
}