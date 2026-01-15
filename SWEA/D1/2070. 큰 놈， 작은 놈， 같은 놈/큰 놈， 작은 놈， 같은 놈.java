import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            char result;


            if (A == B) {
                result = '=';
            } else if (A > B) {
                result = '>';
            } else {
                result = '<';
            }

            System.out.println("#" + testCase + " " + result);
        }
    }
}