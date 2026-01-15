import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            double sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            double result = Math.round(sum / 10);

            System.out.println("#" + testCase + " " + (int) result);
        }
    }
}