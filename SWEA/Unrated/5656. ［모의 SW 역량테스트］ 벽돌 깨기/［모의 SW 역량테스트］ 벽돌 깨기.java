import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int W;
	static int H;
	static int[][] map;
	static int min;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H + 2][W + 2];
			for (int i = 1; i <= H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;

			for (int i = 1; i <= W; i++) {
				int[][] tmp = new int[H + 2][W + 2];
				for (int j = 0; j < H + 2; j++) {
					tmp[j] = Arrays.copyOf(map[j], W + 2);
				}
				
				DFS(i, 1);
				
				map = tmp;
			}
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int ballX, int time) {
		// 종료조건 : 이미 N번 던졌을 때
		if (time >= N + 1) {
			int cnt = 0;
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= W; j++) {
					if (map[i][j] != 0) cnt++;
				}
			}
			
			min = Math.min(min, cnt);
			return;
		}
		
		int[][] tmpMap = new int[H + 2][W + 2];
		for (int i = 0; i < H + 2; i++) {
			tmpMap[i] = Arrays.copyOf(map[i], W + 2);
		}
		
		// 터트리기
		for (int i = 1; i <= H; i++) {
			if (map[i][ballX] != 0) {
				bomb(ballX, i);
				break;
			}
		}
		
		// 정렬 빈공간 채우기
		for (int i = 1; i <= W; i++) {
			for (int j = H; j >= 1; j--) {
				if (map[j][i] != 0) {
					int tmp = map[j][i];
					map[j][i] = 0;
					int y = j;

					while(map[y][i] == 0 && y <= H) {
						y++;
					}
					
					y--;
					map[y][i] = tmp;
				}
			}
		}
		
		// 재귀
		for (int i = 1; i <= W; i++) {
			DFS(i, time + 1);
		}
		
		map = tmpMap;
	}
	
	static void bomb(int x, int y) {
		if(x > W || y > H || x < 1 || y < 1) return;
		
		int length = map[y][x];
		map[y][x] = 0;
		for (int i = 1; i < length; i++) {
			bomb(x + i * dx[0], y + i * dy[0]);
			bomb(x + i * dx[1], y + i * dy[1]);
			bomb(x + i * dx[2], y + i * dy[2]);
			bomb(x + i * dx[3], y + i * dy[3]);
		}
	}
}