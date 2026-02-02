import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tesCase = 1; tesCase <= T; tesCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                if (map[0][i] == i + 1) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }

            int cnt = 0;
            for (int i = N - 1; i > 0; i--) {
                if (arr[i] == 0) {
                    for (int j = i; j > 0; j--) {
                        arr[j] = 1 - arr[j];
                    }
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}