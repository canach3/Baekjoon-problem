import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static int maxCnt;
	static int maxStart;
	static int start;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int N = Integer.parseInt(br.readLine().trim());
			map = new int[N + 2][N + 2];
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxCnt = 0;
			maxStart = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					start = map[i][j];
					DFS(i, j, 1);
				}
			}
			
			sb.append(maxStart).append(" ").append(maxCnt).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int y, int x, int cnt) {
		if (cnt > maxCnt) {
			maxCnt = cnt;
			maxStart = start;
		} else if (cnt == maxCnt) {
			maxStart = Math.min(maxStart,start);
		}
		
		int currentRoom = map[y][x];
		for (int i = 0; i < 4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			int nextRoom = map[nextY][nextX];
			
			if (nextRoom == currentRoom + 1) DFS(nextY, nextX, cnt + 1);
		}
	}
}