import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());

            int total = 0;

            if (B > W) {
                total += (B - W) * X;
            }
            if (W > B) {
                total += (W - B) * Y;
            }

            if (X + Y > 2 * Z) {
                total += Math.min(B, W) * (X + Y);
            } else {
                total += Math.min(B, W) * 2 * Z;
            }

            System.out.println(total);
        }
    }
}