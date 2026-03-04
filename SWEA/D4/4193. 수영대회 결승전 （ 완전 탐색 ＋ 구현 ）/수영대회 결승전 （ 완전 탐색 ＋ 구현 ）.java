import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static int[] start;
	static int[] end;
	static boolean[][] visited;
	static int min;
	static int hCnt;
	
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
					
					if (map[i][j] == 2) {
						hCnt++;
					}
				}
			}
			
			start = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken()) + 1;
			start[1] = Integer.parseInt(st.nextToken()) + 1;
			
			end = new int[2];
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken()) + 1;
			end[1] = Integer.parseInt(st.nextToken()) + 1;	
			
			min = Integer.MAX_VALUE;
			visited = new boolean[N + 2][N + 2];
			visited[start[0]][start[1]] = true;
			
			DFS(start[0], start[1], 0);
			
			if (min == Integer.MAX_VALUE) min = -1;
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int y, int x, int time) {
		// 이미 최소보다 경로가 긴 경우
		if (time > min || time > N * N + (hCnt * 2)) return;
		
		// 목적지에 도달한 경우
		if (y == end[0] && x == end[1]) {
			min = time;
			return;
		}
	
		// 경계를 벗어난 경우, 장애물인 경우
		if (map[y][x] == -1 || map[y][x] == 1) return;
		
		// 소용돌이인 경우 지나갈 수 있는 시간까지 기다리기
		if (map[y][x] == 2) {
			while(time % 3 != 0) time++;
		}
		
		for (int i = 0; i < 4; i++) {
			if (!visited[y + dy[i]][x + dx[i]]) {
				visited[y + dy[i]][x + dx[i]] = true;
				DFS(y + dy[i], x + dx[i], time + 1);
				visited[y + dy[i]][x + dx[i]] = false;
			}
		}
	}
}