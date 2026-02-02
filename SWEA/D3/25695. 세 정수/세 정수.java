import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tesCase = 1; tesCase <= T; tesCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());

            int max = Math.max(X, Math.max(Y, Z));
            int min = Math.min(X, Math.min(Y, Z));
            int cnt = 0;

            if (max == X) {
                cnt++;
            }

            if (max == Y) {
                cnt++;
            }

            if (max == Z) {
                cnt++;
            }

            if (cnt == 3) {
                System.out.println(max + " " + max + " " + max);
            } else if (cnt == 2) {
                if (X == Y) {
                    System.out.println(min + " " + max + " " + min);
                } else if (Y == Z){
                    System.out.println(min + " " + min + " " + max);
                } else {
                    System.out.println(max + " " + min + " " + min);
                }
            } else {
                System.out.println("-1 -1 -1");
            }
        }
    }
}