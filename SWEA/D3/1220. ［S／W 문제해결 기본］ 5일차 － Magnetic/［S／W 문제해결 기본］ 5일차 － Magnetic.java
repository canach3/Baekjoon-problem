import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            int N = Integer.parseInt(br.readLine().trim());

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 교착상태가 발생하는 경우
            // N(1) 입장에서 S(2)가 아래에 있는 경우
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean findN = false;

                for (int j = 0; j < N; j++) {
                    if (map[j][i] == 1) findN = true;

                    if (map[j][i] == 2) {
                        if (findN) {
                            cnt++;
                            findN = false;
                        }
                    }
                }
            }

            sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}