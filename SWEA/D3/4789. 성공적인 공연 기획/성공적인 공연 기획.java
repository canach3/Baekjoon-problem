import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine().trim();

            int sum = input.charAt(0) - '0';
            int result = 0;
            for (int i = 1; i < input.length(); i++) {
                if (sum < i) {
                    result += i - sum;
                    sum += i - sum;
                }

                sum += input.charAt(i) - '0';
            }


            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }
}