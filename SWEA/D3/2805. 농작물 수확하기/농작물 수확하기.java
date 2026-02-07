import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String input = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j] = input.charAt(j) - '0';
                }
            }

            int sum = 0;

            for (int i = 0; i <= N / 2; i++) {
                int j = N / 2 - i;
                for (int time = 0; time < (i+1) * 2 - 1; time++) {
                    sum += map[i][j];
                    j++;
                }
            }

            for (int i = 0; i < N / 2; i++) {
                int j = i + 1;
                for (int time = 0; time < N - 2 - (2 * i); time++) {
                    sum += map[N/2 + 1 + i][j];
                    j++;
                }
            }

            sb.append("#").append(testCase).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }
}