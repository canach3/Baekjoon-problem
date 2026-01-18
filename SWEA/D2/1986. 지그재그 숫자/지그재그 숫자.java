import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if (i % 2 == 1) {
                    sum += i;
                } else {
                    sum -= i;
                }
            }

            System.out.println("#" + testCase + " " + sum);
        }
    }
}