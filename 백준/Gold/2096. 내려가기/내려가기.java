import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dpMax;
    static int[] dpMin;
    static int[][] scores;

    static int idx_0;
    static int idx_1;
    static int idx_2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        dpMax = new int[3];
        dpMin = new int[3];
        scores = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            scores[i][0] = Integer.parseInt(st.nextToken());
            scores[i][1] = Integer.parseInt(st.nextToken());
            scores[i][2] = Integer.parseInt(st.nextToken());
        }

        // 첫째줄 값 초기화
        dpMax[0] = scores[0][0];
        dpMax[1] = scores[0][1];
        dpMax[2] = scores[0][2];
        dpMin[0] = scores[0][0];
        dpMin[1] = scores[0][1];
        dpMin[2] = scores[0][2];

        for (int i = 1; i < N; i++) {
            idx_0 = dpMax[0];
            idx_1 = dpMax[1];
            idx_2 = dpMax[2];
            dpMax[0] = Math.max(idx_0, idx_1) + scores[i][0];
            dpMax[1] = Math.max(idx_0, Math.max(idx_1, idx_2)) + scores[i][1];
            dpMax[2] = Math.max(idx_1, idx_2) + scores[i][2];

            idx_0 = dpMin[0];
            idx_1 = dpMin[1];
            idx_2 = dpMin[2];
            dpMin[0] = Math.min(idx_0, idx_1) + scores[i][0];
            dpMin[1] = Math.min(idx_0, Math.min(idx_1, idx_2)) + scores[i][1];
            dpMin[2] = Math.min(idx_1, idx_2) + scores[i][2];
        }

        int max = Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]));
        int min = Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]));

        System.out.println(max + " " + min);
    }
}