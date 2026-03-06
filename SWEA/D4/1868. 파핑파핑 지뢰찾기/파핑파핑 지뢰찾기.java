import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static char[][] map;
	static boolean[][] check;
	static int cnt;
	
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			map = new char[N + 2][N + 2];
			check = new boolean[N + 2][N + 2];
			
			for (int i = 1; i <= N; i++) {
				String input = br.readLine().trim();
				for (int j = 1; j <= N; j++) {
					map[i][j] = input.charAt(j - 1);
					
					if (map[i][j] == '*') check[i][j] = true;
				}
			}
			
			cnt = 0;
			
			// 0을 먼저 찾고 터트리기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!check[i][j] && isZero(i, j)) {
						cnt++;
						bomb(i, j);
					}
				}
			}
			
			// 나머지 지뢰가 아닌 타일 더하기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!check[i][j]) cnt++;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static boolean isZero(int y, int x) {
		boolean result = true;
		
		for (int i = 0; i < 8; i++) {
			if (map[y + dy[i]][x + dx[i]] == '*') {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	static void bomb(int y, int x) {
		// 경계값 제외
		if (y == 0 || y == N + 1 || x == 0 || x == N + 1) return;
		
		// 해당 타일 check
		check[y][x] = true;
		
		if (isZero(y, x)) {
			for (int i = 0; i < 8; i++) {
				int nextY = y + dy[i];
				int nextX = x + dx[i];
				
				if (!check[nextY][nextX]) bomb(nextY, nextX);
			}
		}
		
	}
}