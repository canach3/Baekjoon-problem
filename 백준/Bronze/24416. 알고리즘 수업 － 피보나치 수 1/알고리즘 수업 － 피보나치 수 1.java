import java.io.*;
import java.util.*;

public class Main {
    static int cnt1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        cnt1 = 0;
        fib1(N);
        System.out.println(cnt1 + " " + (N - 2));
    }

    static int fib1(int n) {
        if (n == 1 || n == 2) {
            cnt1++;
            return 1;
        }
        else return fib1(n - 1) + fib1(n - 2);
    }
}