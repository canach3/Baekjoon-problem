import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (true) {
            boolean isPalindrome = true;
            String s = Integer.toString(N);

            int start = 0;
            int end = s.length() - 1;

            while (start <= end) {
                if (s.charAt(start) != s.charAt(end)) {
                    isPalindrome = false;
                    break;
                }

                start++;
                end--;
            }

            boolean isPrime = true;

            if (N == 1) {
                isPrime = false;
            }

            if (isPalindrome) {
                for (int i = 2; i <= Math.sqrt(N); i++) {
                    if (N % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    System.out.println(N);
                    return;
                }
            }

            N++;
        }
    }
}