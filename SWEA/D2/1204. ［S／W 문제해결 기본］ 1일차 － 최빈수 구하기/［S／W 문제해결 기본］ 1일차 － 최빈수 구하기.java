import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int t = Integer.parseInt(br.readLine());
            int[] scores = new int[101];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                scores[score]++;
            }

            int max = 0;
            for (int i = 0; i < 101; i++) {
                if (scores[i] >= scores[max]) {
                    max = i;
                }
            }

            System.out.println("#" + testCase + " " + max);
        }
    }
}