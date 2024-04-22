import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        String[] board = new String[rows];
        for (int i = 0; i < rows; i++) {
            board[i] = sc.nextLine();
        }

        int minCnt = 64;
        for (int i = 0; i <= rows - 8; i++) {
            for (int j = 0; j <= cols - 8; j++) {
                int result = Math.min(cntWB(board, i, j), cntBW(board, i, j));
                if (minCnt >= result) {
                    minCnt = result;
                }
            }
        }

        System.out.println(minCnt);
    }

    public static int cntWB(String[] board, int row, int col) {
        String[] WB = {
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW"};
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[row + i].charAt(col + j) != WB[i].charAt(j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static int cntBW(String[] board, int row, int col) {
        String[] BW = {
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB"};
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[row + i].charAt(col + j) != BW[i].charAt(j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}