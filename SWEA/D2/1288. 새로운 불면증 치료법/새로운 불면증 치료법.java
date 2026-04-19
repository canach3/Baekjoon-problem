import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine().trim());
            int kN = 0;

            Set<Integer> set = new HashSet<>();
            while (set.size() != 10) {
                kN += N;

                String tmp = String.valueOf(kN);

                for (int i = 0; i < tmp.length(); i++) {
                    set.add(tmp.charAt(i) - '0');
                }
            }

            sb.append(kN).append("\n");
        }

        System.out.print(sb);
    }
}