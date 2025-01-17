import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        // N 크기의 2차원 배열 생성, 값 집어넣기
        int[][] numArr = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                numArr[i][j] = sc.nextInt();
            }
        }

        // 구간합 2차원 배열 생성, 값 집어넣기
        int[][] sumArr = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + numArr[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int result = sumArr[x2][y2] - sumArr[x2][y1-1] - sumArr[x1-1][y2] + sumArr[x1-1][y1-1];
         
            System.out.println(result);
        }
    }
}