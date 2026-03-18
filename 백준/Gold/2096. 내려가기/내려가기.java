import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dpMax;
    static int[] dpMin;

    static int s0;
    static int s1;
    static int s2;

    static int idx_0;
    static int idx_1;
    static int idx_2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        dpMax = new int[3];
        dpMin = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s0 = Integer.parseInt(st.nextToken());
            s1 = Integer.parseInt(st.nextToken());
            s2 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                // 첫째줄 값 초기화
                dpMax[0] = s0;
                dpMax[1] = s1;
                dpMax[2] = s2;
                dpMin[0] = s0;
                dpMin[1] = s1;
                dpMin[2] = s2;
                continue;
            }

            idx_0 = dpMax[0];
            idx_1 = dpMax[1];
            idx_2 = dpMax[2];
            dpMax[0] = Math.max(idx_0, idx_1) + s0;
            dpMax[1] = Math.max(idx_0, Math.max(idx_1, idx_2)) + s1;
            dpMax[2] = Math.max(idx_1, idx_2) + s2;

            idx_0 = dpMin[0];
            idx_1 = dpMin[1];
            idx_2 = dpMin[2];
            dpMin[0] = Math.min(idx_0, idx_1) + s0;
            dpMin[1] = Math.min(idx_0, Math.min(idx_1, idx_2)) + s1;
            dpMin[2] = Math.min(idx_1, idx_2) + s2;
        }

        System.out.println(Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2])) + " " + Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2])));
    }
}