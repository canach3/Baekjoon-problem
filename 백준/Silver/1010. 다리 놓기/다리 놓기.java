import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long result = calculateCombination(n, m);

            System.out.println(result);
        }
    }

    static long calculateCombination(int n, int m) {
        long result = factorial(m, Math.max(n, m - n) + 1) / factorial(Math.min(n, m-n), 1);
        return result;
    }

    static long factorial(int last, int start) {
        long result = 1;
        for (int i = start; i <= last; i++) {
            result *= i;
        }
        return result;
    }
}