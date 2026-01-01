import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[1001][1001];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {
                    map[x+j][y+k] = i;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int sum = 0;

            for (int j = 0; j < 1001; j++) {
                for (int k = 0; k < 1001; k++) {
                    if (map[j][k] == i) {
                        sum++;
                    }
                }
            }

            System.out.println(sum);
        }
    }
}