import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long S = Long.parseLong(st.nextToken());
            long P = Long.parseLong(st.nextToken());
            
            boolean isPossible = false;
            for (long i = 1; i <= Math.sqrt(P); i++) {
                if ((P % i == 0) && (i + (P / i) == S)) {
                    isPossible = true;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}