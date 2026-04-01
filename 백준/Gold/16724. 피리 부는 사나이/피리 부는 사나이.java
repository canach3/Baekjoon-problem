import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static int[][] type;
    static int cnt;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }
        type = new int[N][M];

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (type[i][j] == 0) {
                    DFS(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    static void DFS(int y, int x) {
        type[y][x]++;

        int d = 0;
        switch (map[y][x]) {
            case 'U':
                break;
            case 'D':
                d = 1;
                break;
            case 'L':
                d = 2;
                break;
            case 'R':
                d = 3;
                break;
        }

        int nextY = y + dy[d];
        int nextX = x + dx[d];

        if (type[nextY][nextX] == 0) DFS(nextY, nextX);
        else if (type[nextY][nextX] == 1) cnt++;

        type[y][x]++;
    }
}