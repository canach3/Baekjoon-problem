import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringBuilder sb = new StringBuilder();

            int type = 50000;
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < 8; i++) {
                sb.append(N / type).append(" ");
                N %= type;
                type /= (i % 2 == 0 ? 5 : 2);
            }

            System.out.println("#" + testCase);
            System.out.println(sb);
        }
    }
}