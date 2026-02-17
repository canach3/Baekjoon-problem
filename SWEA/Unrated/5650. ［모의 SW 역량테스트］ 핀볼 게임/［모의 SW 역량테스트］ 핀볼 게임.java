import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static int[][] wormhole;
	static int max;
	static int startX;
	static int startY;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int[][] blockDir = {
	        {}, 
	        {2, 3, 1, 0}, 
	        {1, 3, 0, 2}, 
	        {3, 2, 0, 1}, 
	        {2, 0, 3, 1},
	        {2, 3, 0, 1}};
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					map[i][j] = 5;
				}
			}

			wormhole = new int[11][4];
			for (int i = 0; i <= 10; i++) {
				wormhole[i][0] = -1;
				wormhole[i][1] = -1;
				wormhole[i][2] = -1;
				wormhole[i][3] = -1;
			}
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (map[i][j] >= 6) {
						int hole = map[i][j];
						
						if (wormhole[hole][0] == -1) {
							wormhole[hole][0] = i;
							wormhole[hole][1] = j;
						} else {
							wormhole[hole][2] = i;
							wormhole[hole][3] = j;
						}
					}
				}
			}
			
			max = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 0) {
						startY = i;
						startX = j;
						
						game(i, j, 0, 0);
						game(i, j, 1, 0);
						game(i, j, 2, 0);
						game(i, j, 3, 0);
					}
				}
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void game(int y, int x, int direction, int score) {
		while (true) {
			// 진행방향으로 전진
			y += dy[direction];
			x += dx[direction];
			
			// 시작위치로 돌아오거나 블랙홀에 빠지면 종료
			if (map[y][x] == -1 || (y == startY && x == startX)) {
				max = Math.max(max, score);
				return;
			}
			
			// 블록인 경우 : 점수증가, 방향전환
			if (map[y][x] >= 1 && map[y][x] <= 5) {
				score++;
				
				int block = map[y][x];
				direction = blockDir[block][direction]; 
                continue;
			}
			
			// 웜홀인 경우 : 동일번호 웜홀로 이동
			if (map[y][x] >= 6) {
				int hole = map[y][x];
				
				if (wormhole[hole][0] == y && wormhole[hole][1] == x) {
					y = wormhole[hole][2];
					x = wormhole[hole][3];
				} else {
					y = wormhole[hole][0];
					x = wormhole[hole][1];
				}
			}
		}
	}
}