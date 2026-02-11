import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            String input = br.readLine().trim();

            int cnt = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                    cnt++;
                    i++;
                } else if (input.charAt(i) == ')') {
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}