import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static int white;
	static int blue;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			white = 0;
			blue = 0;
			DFS(0, 0, N);
			
			sb.append(white).append(" ").append(blue).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int y, int x, int size) {
		// 종료조건 : 색종이의 크기가 1인 경우
		if (size == 1) {
			if (map[y][x] == 0) white++;
			else blue++;
			return;
		}
		
		// idx부터 size 크기만큼 조사
		boolean isSame = true;
		int color = map[y][x];
		
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] != color) {
					isSame = false;
					break;
				}
			}
			if(!isSame) break;
		}
		
		// 동일한 색인 경우
		if (isSame) {
			if (color == 0) white++;
			else blue++;
			return;
		}
		
		// 동일하지 않은 경우
		DFS(y, x, size / 2);
		DFS(y + size / 2, x, size / 2);
		DFS(y, x + size / 2, size / 2);
		DFS(y + size / 2, x + size / 2, size / 2);
	}
}