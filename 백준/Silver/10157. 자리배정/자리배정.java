import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		int x = 0;
		int y = R - 1;
		int order = 1;
		int current = 4;
		
		while (map[y][x] == 0) {
			map[y][x] = order++;
			
			if (current == 4) {
				if (y <= 0 || map[y - 1][x] != 0) {
					current = 1;
					x++;
				} else {
					y--;
				}
			} else if (current == 1) {
				if (x >= C-1 || map[y][x + 1] != 0) {
					current = 3;
					y++;
				} else {
					x++;
				}
			} else if (current == 3) {
				if (y >= R-1 || map[y + 1][x] != 0) {
					current = 2;
					x--;
				} else {
					y++;
				}
			} else if (current == 2) {
				if (x <= 0 || map[y][x - 1] != 0) {
					current = 4;
					y--;
				} else {
					x--;
				}
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == K) {
					System.out.println((j + 1) + " " + (R - i));
					return;
				}
			}
		}
		
		System.out.println(0);
	}
}