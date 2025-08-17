import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long gcd = GCD(Math.max(A, B), Math.min(A, B));


        for (int i = 0; i < gcd; i++) {
            sb.append(1);
        }

        System.out.println(sb);
    }

    static long GCD(long A, long B) {
        if (A % B == 0) {
            return B;
        }

        return GCD(B, A % B);
    }
}