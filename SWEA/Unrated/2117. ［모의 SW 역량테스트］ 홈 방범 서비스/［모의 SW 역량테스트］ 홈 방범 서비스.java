import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            List<int[]> houses = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        // 집의 x, y좌표를 담음
                        houses.add(new int[]{i, j});
                    }
                }
            }

            // 최대 K 구하기 = 최대 수익을 넘지 않는 선에서의 가장 큰 K
            int K = 21;
            while (K * K + (K - 1) * (K - 1) > (houses.size() * M)) {
                K--;
            }

            int maxHouse = 0;
            while (K >= 0) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        int cnt = 0;

                        // 중앙으로부터 (K-1) 내로 떨어진 집은 전부 커버 가능.
                        // 커버 가능한 집이면 cnt++
                        for (int[] house : houses) {
                            if (K > Math.abs(i - house[0]) + Math.abs(j - house[1])) {
                                cnt++;
                            }
                        }

                        // 총 이익이 마이너스가 아니면, 커버한 집 개수 비교후 업데이트
                        if (cnt * M >= K * K + (K - 1) * (K - 1)) {
                            if (cnt > maxHouse) {
                                maxHouse = cnt;
                            }
                        }
                    }
                }

                // 수익이 마이너스가 아니면 최대임이 보장되므로 break;
                if (maxHouse > 0) break;
                K--;
            }

            sb.append("#" + testCase + " " + maxHouse + "\n");
        }

        System.out.print(sb);
    }
}