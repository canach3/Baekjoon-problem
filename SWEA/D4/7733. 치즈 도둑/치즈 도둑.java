import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map;
    static int[][] cheeseArr;
    static int[] parent;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            cheeseArr = new int[N * N][2];

            parent = new int [N * N];
            for (int i = 0; i < N * N; i++) {
                parent[i] = i;
            }

            int days = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int taste = Integer.parseInt(st.nextToken());
                    map[i][j] = taste;
                    cheeseArr[N * i + j][0] = N * i + j;
                    cheeseArr[N * i + j][1] = taste;

                    days = Math.max(days, taste);
                }
            }

            // taste 기준으로 내림차순 정렬
            Arrays.sort(cheeseArr, (a, b) -> Integer.compare(b[1], a[1]));

            int maxCnt = 1;
            int cnt = 0;
            int start = 0;

            for (int day = days; day > 0; day--) {
                for (int i = start; i < N * N; i++) {
                    int idx = cheeseArr[i][0];
                    int taste = cheeseArr[i][1];

                    // 해당 day와 동일한 taste인지 체크
                    if (taste != day) {
                        start = i;
                        break;
                    }

                    cnt++;

                    int y = idx / N;
                    int x = idx % N;
                    for (int j = 0; j < 4; j++) {
                        int nextY = y + dy[j];
                        int nextX = x + dx[j];
                        int nextIdx = N * nextY + nextX;

                        if (nextY == -1 || nextY == N || nextX == -1 || nextX == N) continue;

                        // 상하좌우에 더 높은 taste 가 있는 경우 : 루트가 다른 경우 cnt--;
                        if (map[nextY][nextX] >= taste) {
                            if (union(idx, nextIdx)) {
                                cnt--;
                            }
                        }
                    }
                }

                maxCnt = Math.max(maxCnt, cnt);
            }

            sb.append(maxCnt).append("\n");
        }

        System.out.print(sb);
    }

    static boolean union(int v1, int v2) {
        int v1Root = find(v1);
        int v2Root = find(v2);

        if (v1Root == v2Root) return false;

        parent[v2Root] = v1Root;
        return true;
    }

    static int find(int v) {
        if (parent[v] == v) return v;

        return parent[v] = find(parent[v]);
    }
}