import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] numArr = new int[N+1][N+1];
        int[][] sumArr = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                numArr[i][j] = sc.nextInt();
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + numArr[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int result = sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1];
            System.out.println(result);
        }
    }
}