import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }

        star(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void star(int y, int x, int size) {
        if (size == 3) {
            for (int i = 0; i < 3; i++) map[y][x + i] = '*';
            map[y + 1][x] = '*';
            map[y + 1][x + 2] = '*';
            for (int i = 0; i < 3; i++) map[y + 2][x + i] = '*';
            return;
        }

        size /= 3;

        // 3분의 1 크기 상단 세 개
        for (int i = 0; i < 3; i++) {
            star(y, x + (i * size), size);
        }

        // 3분의 1 크기 중단 두 개
        star(y + size, x, size);
        star(y + size, x + size * 2, size);

        // 3분의 1 크기 하단 세 개
        for (int i = 0; i < 3; i++) {
            star(y + size * 2, x + (i * size), size);
        }
    }
}