import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                int input = Integer.parseInt(st.nextToken());

                if (input % 2 == 1) {
                    sum += input;
                }
            }


            System.out.println("#" + testCase + " " + sum);
        }
    }
}