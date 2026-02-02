import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt (st.nextToken());
            int Q = Integer.parseInt (st.nextToken());
            int R = Integer.parseInt (st.nextToken());
            int S = Integer.parseInt (st.nextToken());
            int W = Integer.parseInt (st.nextToken());

            int AAmount = P * W;
            int BAmount = Q + (R < W ? W-R : 0) * S;

            System.out.println("#" + testCase + " " + Math.min(AAmount, BAmount));
        }
    }
}