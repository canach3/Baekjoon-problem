import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            String input = br.readLine().trim();

            int cnt = 0;
            for (char bit : input.toCharArray()) {
                if (bit == '0' && cnt % 2 != 0) cnt++;
                if (bit == '1' && cnt % 2 == 0) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}