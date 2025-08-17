import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int gcd = GCD(Math.max(A, B), Math.min(A, B));

            int result = A * B / gcd;
            System.out.println(result);
        }
    }

    static int GCD(int A, int B) {
        if (A % B == 0) {
            return B;
        }

        return GCD(B, A % B);
    }
}