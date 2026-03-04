import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
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
					map[i][j] = -1;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] start = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken()) + 1;
			start[1] = Integer.parseInt(st.nextToken()) + 1;
			
			int[] end = new int[2];
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken()) + 1;
			end[1] = Integer.parseInt(st.nextToken()) + 1;	
			
			visited = new boolean[N + 2][N + 2];
			int min = BFS(start[0], start[1], end[0], end[1]);
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static int BFS(int startY, int startX, int endY, int endX) {
		visited[startY][startX] = true;
		
		Deque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[] {startY, startX, 0});
		
		while(!deque.isEmpty()) {
			int[] current = deque.pollFirst();
			int time = current[2];
			
			if (current[0] == endY && current[1] == endX) {
				return time;
			}
			
			// 상하좌우 이동
			for (int i = 0; i < 4; i++) {
				int nextY = current[0] + dy[i];
				int nextX = current[1] + dx[i];
				
				if (!visited[nextY][nextX] && map[nextY][nextX] != -1 && map[nextY][nextX] != 1) {

					// 다음 타일이 소용돌이인 경우
					if (map[nextY][nextX] == 2) {
						if (time % 3 == 2) {
							visited[nextY][nextX] = true;
							deque.addLast(new int[] {nextY, nextX, time + 1});
						} else {
							deque.addLast(new int[] {current[0], current[1], time + 1});
						}
					} else {
						visited[nextY][nextX] = true;
	                    deque.addLast(new int[] {nextY, nextX, time + 1});
					}
				}
			}
			
		}
		
		// 목적지에 도착한 시간 반환
		return -1;
	}
}