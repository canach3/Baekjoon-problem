import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tesCase = 1; tesCase <= T; tesCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input.charAt(j);

                }
            }

            int cnt = 0;

            if (W >= H) {
                for (int i = 0; i < H; i++) {
                    boolean painting = true;
                    for (int j = 0; j < W; j++) {
                        if (map[i][j] != '#') {
                            painting = false;
                            break;
                        }
                    }

                    if (painting) {
                        cnt++;
                    }
                }

                if (cnt == H) {
                    System.out.println(cnt);
                    continue;
                }

                for (int i = 0; i < W; i++) {
                    boolean painting = true;
                    for (int j = 0; j < H; j++) {
                        if (map[j][i] != '#') {
                            painting = false;
                            break;
                        }
                    }

                    if (painting) {
                        cnt++;
                    }
                }
            } else {
                for (int i = 0; i < W; i++) {
                    boolean painting = true;
                    for (int j = 0; j < H; j++) {
                        if (map[j][i] != '#') {
                            painting = false;
                            break;
                        }
                    }

                    if (painting) {
                        cnt++;
                    }
                }

                if (cnt == W) {
                    System.out.println(cnt);
                    continue;
                }

                for (int i = 0; i < H; i++) {
                    boolean painting = true;
                    for (int j = 0; j < W; j++) {
                        if (map[i][j] != '#') {
                            painting = false;
                            break;
                        }
                    }

                    if (painting) {
                        cnt++;
                    }
                }

            }

            System.out.println(cnt);
        }
    }
}