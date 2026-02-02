import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;

            while(N != 1) {
                if (N % 2 == 0) {
                    N /= 2;
                    a++;
                }

                if (N % 3 == 0) {
                    N /= 3;
                    b++;
                }

                if (N % 5 == 0) {
                    N /= 5;
                    c++;
                }

                if (N % 7 == 0) {
                    N /= 7;
                    d++;
                }

                if (N % 11 == 0) {
                    N /= 11;
                    e++;
                }
            }

            System.out.println("#" + testCase + " " + a + " " + b + " " + c + " " + d + " " + e);
        }
    }
}