import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
             
            int[][]map = new int[N][N];
             
            int x = 0;
            int y = 0;
            int state = 1;
             
            for (int i = 0; i < N * N; i++) {
                map[y][x] = i + 1;
                 
                if (state == 1) {
                    if (x + 1 >= N || map[y][x + 1] != 0) {
                        state = 2;
                        y++;
                    } else {
                        x++;
                    }
                } else if (state == 2) {
                    if (y + 1 >= N || map[y + 1][x] != 0) {
                        state = 3;
                        x--;
                    } else {
                        y++;
                    }               
                } else if (state == 3) {
                    if (x <= 0 || map[y][x - 1] != 0) {
                        state = 4;
                        y--;
                    } else {
                        x--;
                    }   
                } else if (state == 4) {
                    if (y <= 0 || map[y - 1][x] != 0) {
                        state = 1;
                        x++;
                    } else {
                        y--;
                    }   
                }
            }
 
            System.out.println("#" + testCase);
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}