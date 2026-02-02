import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int min = 10000;
            int max = 0;
            int sum = 0;

            for (int i = 0; i < 10; i++) {
                int input = Integer.parseInt(st.nextToken());
                sum += input;
                max = Math.max(input, max);
                min = Math.min(input, min);
            }

            sum = sum - max - min;


            System.out.println("#" + testCase + " " + Math.round((double) sum / 8));
        }
    }
}