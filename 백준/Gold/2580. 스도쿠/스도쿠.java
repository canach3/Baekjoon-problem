import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static ArrayList<int[]> emptyCells;

    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        emptyCells = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }

        DFS(0);
    }

    static void DFS(int idx) {
        if (idx == emptyCells.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        int y = emptyCells.get(idx)[0];
        int x = emptyCells.get(idx)[1];

        for (int i = 1; i <= 9; i++) {
            boolean isPossible = true;

            // 가로 검사
            for (int j = x - 1; j >= 0; j--) {
                if (map[y][j] == i) {
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible) continue;

            for (int j = x + 1; j < 9; j++) {
                if (map[y][j] == i) {
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible) continue;

            // 세로 검사
            for (int j = y - 1; j >= 0; j--) {
                if (map[j][x] == i) {
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible) continue;

            for (int j = y + 1; j < 9; j++) {
                if (map[j][x] == i) {
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible) continue;

            // 9칸 검사
            int startY = (y / 3) * 3;
            int startX = (x / 3) * 3;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int nextY = startY + j;
                    int nextX = startX + k;

                    if (nextY == y && nextX == x) continue;

                    if (map[nextY][nextX] == i) {
                        isPossible = false;
                        break;
                    }
                }

                if (!isPossible) break;
            }

            if (!isPossible) continue;

            // 가능하다면 다음 빈 셀로 이동
            map[y][x] = i;
            DFS(idx + 1);
            map[y][x] = 0;
        }
    }
}