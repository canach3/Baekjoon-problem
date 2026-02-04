import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int cntOdd = 0;
            if (A % 2 != 0) cntOdd++;
            if (B % 2 != 0) cntOdd++;
            if (C % 2 != 0) cntOdd++;

            if (cntOdd == 3) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
    }
}