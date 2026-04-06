import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine().trim());

        if (cnt == 1) {
            int N = Integer.parseInt(br.readLine().trim());
            System.out.println(N * N);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n1 = Integer.parseInt(st.nextToken());
        long min = n1;
        long max = n1;
        long LCM = 0;

        for (int i = 1; i < cnt; i++) {
            long n2 = Integer.parseInt(st.nextToken());
            max = Math.max(max, n2);
            min = Math.min(min, n2);
            
            LCM = n1 * n2 / GCD(n1, n2);
            n1 = LCM;
        }

        if (LCM == max) LCM *= min;

        System.out.println(LCM);
    }

    static long GCD(long n1, long n2) {
        long mod = n1 % n2;

        if (mod == 0) return n2;

        return GCD(n2, mod);
    }
}