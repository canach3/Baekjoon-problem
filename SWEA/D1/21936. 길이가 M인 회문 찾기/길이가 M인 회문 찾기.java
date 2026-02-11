import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String input = br.readLine().trim();

            String result = "";

            for (int i = 0; i <= input.length() - M; i++) {
                String word = input.substring(i, i + M);

                boolean isP = true;
                for (int j = 0; j < M / 2; j++) {
                    if (word.charAt(j) != word.charAt(M - 1 - j)) {
                        isP = false;
                        break;
                    }
                }

                if (isP) {
                    result = word;
                    break;
                }
            }

            sb.append(result.equals("") ? "NONE" : result).append("\n");
        }

        System.out.print(sb);
    }
}