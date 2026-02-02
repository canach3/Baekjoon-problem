import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = 0;
            for (int i = 0; i < 10; i++) {
                int input = Integer.parseInt(st.nextToken());
                max = Math.max(input, max);
            }

            System.out.println("#" + testCase + " " + max);
        }
    }
}