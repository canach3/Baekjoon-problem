import java.io.*;
import java.util.*;
 
public class Solution {
	static int[][] map;
	static boolean visited[][];
	static int max;
	static int K;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					map[i][j] = 100;
				}
			}
			
			int highest = 0;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (map[i][j] > highest) highest = map[i][j];
				}
			}
			
			max = 0;
			visited = new boolean[N + 2][N + 2];	
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == highest) DFS(i, j, 1, false);
				}
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int y, int x, int length, boolean useK) {
		visited[y][x] = true;
		
		max = Math.max(max, length);
		
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if (!visited[nextY][nextX] && map[nextY][nextX] != 100) {
				if (map[y][x] <= map[nextY][nextX]) {
					if (!useK && map[y][x] > map[nextY][nextX] - K) {
						int tmp = map[nextY][nextX];
						map[nextY][nextX] = map[y][x] - 1;
						DFS(nextY, nextX, length + 1, true);
						map[nextY][nextX] = tmp;
					}
					
				} else {
					DFS(nextY, nextX, length + 1, useK);
				}
			}
		}
		
		visited[y][x] = false;
	}
}