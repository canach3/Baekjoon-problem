import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            int N = Integer.parseInt(br.readLine().trim());

            int[][] busLines = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                busLines[i][0] = Integer.parseInt(st.nextToken());
                busLines[i][1] = Integer.parseInt(st.nextToken());
            }

            int P = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < P; i++) {
                int cnt = 0;
                int busStop = Integer.parseInt(br.readLine().trim());

                for (int j = 0; j < N; j++) {
                    if (busStop >= busLines[j][0] && busStop <= busLines[j][1]) {
                        cnt++;
                    }
                }

                sb.append(cnt).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}