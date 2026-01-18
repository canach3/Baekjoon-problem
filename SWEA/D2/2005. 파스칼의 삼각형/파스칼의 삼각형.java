import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N + 1][N + 1];

            map[1][1] = 1;

            for (int i = 2; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                    map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
                }
            }

            System.out.println("#" + testCase);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}