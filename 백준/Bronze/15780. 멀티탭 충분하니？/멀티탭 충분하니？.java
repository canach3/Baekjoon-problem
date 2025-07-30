import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int sum = 0;

        for (int i = 0; i < K; i++) {
            int holes = sc.nextInt();
            if (holes % 2 == 0) {
                sum += holes / 2;
            } else {
                sum += holes / 2 + 1;
            }
        }

        if (sum >= N) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}