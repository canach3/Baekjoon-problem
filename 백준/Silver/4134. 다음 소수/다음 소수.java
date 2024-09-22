import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            if (num == 0 || num == 1) {
                System.out.println(2);
                continue;
            }

            while (true) {
                boolean isPrime = true;

                for (int j = 2; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    System.out.println(num);
                    break;
                } else {
                    num++;
                }
            }

        }
    }
}