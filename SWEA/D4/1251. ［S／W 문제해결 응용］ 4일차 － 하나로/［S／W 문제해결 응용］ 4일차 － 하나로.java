import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static boolean[] visited;
    static int[][] island;
    static long[] dist;

    public static void main(String[] args) throws IOException{
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            N = Integer.parseInt(br.readLine().trim());

            island = new int[N + 1][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                island[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                island[i][0] = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            dist = new long[N + 1];
            for (int i = 1; i <= N; i++) {
                dist[i] = Long.MAX_VALUE;
            }
            dist[1] = 0;

            visited = new boolean[N + 1];

            long totalCost = 0;
            for (int i = 1; i <= N; i++) {
                long min = Long.MAX_VALUE;
                int current = 0;

                // 방문하지 않은 섬 중 가장 가까운 섬 찾기
                for (int j = 1; j <= N; j++) {
                    if (!visited[j] && dist[j] < min) {
                        min = dist[j];
                        current = j;
                    }
                }

                visited[current] = true;
                totalCost += dist[current];

                for (int next = 1; next <= N; next++) {
                    if (visited[next]) continue;

                    long newCost = getCost(island[current][0], island[current][1], island[next][0], island[next][1]);

                    dist[next] = Math.min(dist[next], newCost);
                }
            }

            sb.append(Math.round(totalCost * E)).append("\n");
        }

        System.out.print(sb);
    }

    static long getCost(int aY, int aX, int bY, int bX) {
        long y = aY - bY;
        long x = aX - bX;

        return y*y + x*x;
    }
}