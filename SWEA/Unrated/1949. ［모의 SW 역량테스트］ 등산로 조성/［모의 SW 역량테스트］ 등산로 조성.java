import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean visited[][];
    static Set<Integer> lengths;
    static int K;
    static boolean useK;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N + 2][N + 2];
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    map[i][j] = 100;
                }
            }

            int max = 0;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > max) {
                        max = map[i][j];
                    }
                }
            }

            lengths = new HashSet<>();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == max) {
                        visited = new boolean[N + 2][N + 2];
                        DFS(j, i, 1);
                    }
                }
            }

            int longest = 0;
            for (Integer length : lengths) {
                if (length > longest) {
                    longest = length;
                }
            }


            sb.append("#" + testCase + " " + longest + "\n");
        }

        System.out.print(sb);
    }

    static void DFS(int x, int y, int cnt) {
        visited[y][x] = true;

        boolean last = true;
        for (int i = 0; i < 4; i++) {
            int currentHeight = map[y][x];
            int nextHeight = map[y + dy[i]][x + dx[i]];

            if (!visited[y + dy[i]][x + dx[i]]) { // 아직 방문 안 했다면
                if (currentHeight > nextHeight) { // 내 위치보다 낮은 위치라면
                    DFS(x + dx[i], y + dy[i], cnt + 1);
                    last = false;

                } else if (!useK && currentHeight > nextHeight - K) { // K를 써서 내 위치보다 낮아진다면
                    map[y + dy[i]][x + dx[i]] -= nextHeight - currentHeight + 1;
                    useK = true;

                    DFS(x + dx[i], y + dy[i], cnt + 1);

                    map[y + dy[i]][x + dx[i]] += nextHeight - currentHeight + 1;
                    useK = false;
                    last = false;
                }
            }

        }
        if (last) {
            lengths.add(cnt);
        }

        visited[y][x] = false;
    }
}