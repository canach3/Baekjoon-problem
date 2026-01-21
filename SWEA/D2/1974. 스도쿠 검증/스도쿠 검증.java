import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int[][] map = new int[10][10];

            for (int i = 1; i <= 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean isSuccess = true;

            // 가로
            for (int i = 1; i <= 9; i++) {
                int[] check = new int[10];

                for (int j = 1; j <= 9; j++) {
                    if (check[map[i][j]] >= 1) {
                        isSuccess = false;
                        break;
                    }

                    check[map[i][j]]++;
                }

                if (!isSuccess) break;
            }

            // 세로
            for (int i = 1; i <= 9; i++) {
                int[] check = new int[10];

                for (int j = 1; j <= 9; j++) {
                    if (check[map[j][i]] >= 1) {
                        isSuccess = false;
                        break;
                    }

                    check[map[j][i]]++;
                }

                if (!isSuccess) break;
            }

            // 정사각형
            for (int i = 2; i <= 8; i += 3) {
                for (int j = 2; j <= 8; j+= 3) {
                    int[] check = new int[10];

                    for (int k = 0; k < 9; k++) {
                        if (check[map[i + dy[k]][j + dx[k]]] >= 1) {
                            isSuccess = false;
                            break;
                        }

                        check[map[i + dy[k]][j + dx[k]]]++;
                    }

                    if (!isSuccess) break;
                }

                if (!isSuccess) break;
            }

            System.out.println("#" + testCase + " " + (isSuccess ? 1 : 0));
        }
    }
}