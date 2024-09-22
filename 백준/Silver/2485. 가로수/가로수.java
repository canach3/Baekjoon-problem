import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] trees = new int[n];

        int gcd = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = sc.nextInt();

            if (i >= 1) {
                int interval = trees[i] - trees[i-1];

                if (i == 1) {
                    gcd = interval;
                } else {
                    if (interval % gcd != 0) {
                        gcd = gcd(interval, gcd);
                    }
                }
            }
        }

        int result = (trees[n-1] - trees[0]) / gcd + 1 - trees.length;

        System.out.println(result);
    }

   static int gcd(int a, int b) {
       if (b == 0) {
           return a;
       } else {
           return gcd(b, a % b);
       }
   }
}