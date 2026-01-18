import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = 0;
            int min = Integer.MAX_VALUE;
            double sum = 0;

            for (int i = 0; i < 10; i++) {
                int N = Integer.parseInt(st.nextToken());

                if (N > max) {
                    max = N;
                }

                if (N < min) {
                    min = N;
                }

                sum += N;
            }

            sum = sum - max - min;

            System.out.println("#" + testCase + " " + Math.round(sum  / 8));
        }
    }
}