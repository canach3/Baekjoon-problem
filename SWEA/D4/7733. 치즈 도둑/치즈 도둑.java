import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static boolean[][] visited1;
	static boolean[][] visited2;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			
			map = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 1;
			visited1 = new boolean[N + 2][N + 2];
			
			for (int time = 1; time <= 100; time++) {
				int cnt = countIsland(time);
				
				if (cnt == 0) break;
				
				max = Math.max(max, cnt);
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static int countIsland(int time) {
		int cnt = 0;
		visited2 = new boolean[N + 2][N + 2];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 0 || visited1[i][j]) continue;
				
				// 바다 처리
				if (map[i][j] <= time) {
					BFS(i, j, time, true);
				}
				
				
				// 섬 처리
				else {
					if(!visited2[i][j]) {
						BFS(i, j, time, false);
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	}
	
	static void BFS(int y, int x, int time, boolean isVisited1) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[] {y, x});
		
		if (isVisited1) visited1[y][x] = true;
		else visited2[y][x] = true;
		
		while(!deque.isEmpty()) {
			int[] tmp = deque.pollFirst();
			int currY = tmp[0];
			int currX = tmp[1];
			
			for (int i = 0; i < 4; i++) {
				int nextY = currY + dy[i];
				int nextX = currX + dx[i];
				
				if (map[nextY][nextX] == 0 || visited1[nextY][nextX]) continue;
				
				if (isVisited1) {
					if (map[nextY][nextX] > time) continue;
					
					visited1[nextY][nextX] = true;
					deque.addLast(new int[] {nextY, nextX});
				}
				
				else {
					if (map[nextY][nextX] <= time || visited2[nextY][nextX]) continue;
					
					visited2[nextY][nextX] = true;
					deque.addLast(new int[] {nextY, nextX});
				}
			}
		}
	}
}