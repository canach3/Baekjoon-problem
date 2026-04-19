import java.io.*;
import java.util.*;

public class Solution {
    static final int TARGET_MASK = (1 << 10) - 1;
    public static void main(String[] args) throws IOException{
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine().trim());

            int visited = 0;
            int KN = 0;

            while ((visited & TARGET_MASK) != TARGET_MASK) {
                KN += N;
                int tmp = KN;

                while (tmp > 0) {
                    int num = tmp % 10;
                    tmp /= 10;

                    visited = (visited | (1 << num));
                }
            }

            sb.append(KN).append("\n");
        }

        System.out.print(sb);
    }
}
