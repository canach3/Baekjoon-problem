import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = N; i <= M; i++) {
            boolean primeNum = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    primeNum = false;
                    break;
                }
            }

            if (i == 1) {
                primeNum = false;
            }

            if (primeNum) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}