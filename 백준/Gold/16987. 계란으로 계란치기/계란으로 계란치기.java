import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] eggs;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        eggs = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        DFS(0);

        System.out.println(max);
    }

    static void DFS(int idx) {
        // 종료조건
        if (idx == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (eggs[i][0] <= 0) cnt++;
            }

            max = Math.max(max, cnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == idx) continue;

            // 내가 혹은 치려는 계란의 내구도 <= 0 인 경우 그냥 넘기기
            if (eggs[i][0] <= 0 || eggs[idx][0] <= 0) {
                DFS(idx + 1);
                continue;
            }

            // 계란 치고 넘기기
            eggs[i][0] -= eggs[idx][1];
            eggs[idx][0] -= eggs[i][1];

            DFS(idx + 1);

            eggs[i][0] += eggs[idx][1];
            eggs[idx][0]+= eggs[i][1];
        }
    }
}