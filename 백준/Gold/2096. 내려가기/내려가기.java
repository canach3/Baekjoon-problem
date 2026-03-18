import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dpMax;
    static int[][] dpMin;
    static int[][] scores;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        dpMax = new int[N + 1][3];
        dpMin = new int[N + 1][3];
        scores = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            scores[i][0] = Integer.parseInt(st.nextToken());
            scores[i][1] = Integer.parseInt(st.nextToken());
            scores[i][2] = Integer.parseInt(st.nextToken());
        }

        // 첫째줄 값 초기화
        dpMax[1][0] = scores[1][0];
        dpMax[1][1] = scores[1][1];
        dpMax[1][2] = scores[1][2];
        dpMin[1][0] = scores[1][0];
        dpMin[1][1] = scores[1][1];
        dpMin[1][2] = scores[1][2];

        for (int i = 2; i <= N; i++) {
            dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]) + scores[i][0];
            dpMax[i][1] = Math.max(dpMax[i - 1][0], Math.max(dpMax[i - 1][1], dpMax[i - 1][2])) + scores[i][1];
            dpMax[i][2] = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]) + scores[i][2];

            dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]) + scores[i][0];
            dpMin[i][1] = Math.min(dpMin[i - 1][0], Math.min(dpMin[i - 1][1], dpMin[i - 1][2])) + scores[i][1];
            dpMin[i][2] = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]) + scores[i][2];
        }

        int max = Math.max(dpMax[N][0], Math.max(dpMax[N][1], dpMax[N][2]));
        int min = Math.min(dpMin[N][0], Math.min(dpMin[N][1], dpMin[N][2]));

        System.out.println(max + " " + min);
    }
}