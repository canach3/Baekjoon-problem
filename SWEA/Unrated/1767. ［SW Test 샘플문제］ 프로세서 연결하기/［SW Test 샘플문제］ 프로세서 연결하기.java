import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static int maxCore;
	static int minLine;
	static List<int[]> cores;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			cores = new ArrayList<>();
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (map[i][j] == 1) {
						cores.add(new int[] {i, j});
					}
				}
			}
			
			maxCore = 0;
			minLine = Integer.MAX_VALUE;
			DFS(0, 0, 0);
			
			sb.append(minLine).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int idx, int coreCnt, int lineCnt) {
		// 종료조건 : 모든 core 검사 완료
		if (idx == cores.size()) {
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				minLine = lineCnt;
			} else if (coreCnt == maxCore) {
				minLine = Math.min(minLine, lineCnt);
			}
			
			return;
		}
		
		int y = cores.get(idx)[0];
		int x = cores.get(idx)[1];
		
		// core가 벽에 붙어있는 경유
		if (y == 0 || y == N - 1 || x == 0 || x == N - 1) {
			DFS(idx + 1, coreCnt + 1, lineCnt);
			return;
		}
		
		// 전원을 연결하지 않은 경우
		DFS(idx + 1, coreCnt, lineCnt);
		
		// 전원을 연결한 경우
		
		// 상
		boolean isPossible = true;
		int line = 0;
		for (int i = 1; y - i >= 0; i++) {
			if (map[y - i][x] == 1) {
				isPossible = false;
				break;
			}
		}
		
		if (isPossible) {
			for (int i = 1; y - i >= 0; i++) {
				map[y - i][x] = 1;
				line++;
			}
			
			DFS(idx + 1, coreCnt + 1, lineCnt + line);
			
			for (int i = 1; y - i >= 0; i++) {
				map[y - i][x] = 0;
			}
		}
		
		// 하
		isPossible = true;
		line = 0;
		for (int i = 1; y + i < N; i++) {
			if (map[y + i][x] == 1) {
				isPossible = false;
				break;
			}
		}
		
		if (isPossible) {
			for (int i = 1; y + i < N; i++) {
				map[y + i][x] = 1;
				line++;
			}
			
			DFS(idx + 1, coreCnt + 1, lineCnt + line);
			
			for (int i = 1; y + i < N; i++) {
				map[y + i][x] = 0;
			}
		}
		
		// 좌
		isPossible = true;
		line = 0;
		for (int i = 1; x - i >= 0; i++) {
			if (map[y][x - i] == 1) {
				isPossible = false;
				break;
			}
		}
		
		if (isPossible) {
			for (int i = 1; x - i >= 0; i++) {
				map[y][x - i] = 1;
				line++;
			}
			
			DFS(idx + 1, coreCnt + 1, lineCnt + line);
			
			for (int i = 1; x - i >= 0; i++) {
				map[y][x - i] = 0;
			}
		}
		
		// 우
		isPossible = true;
		line = 0;
		for (int i = 1; x + i < N; i++) {
			if (map[y][x + i] == 1) {
				isPossible = false;
				break;
			}
		}
		
		if (isPossible) {
			for (int i = 1; x + i < N; i++) {
				map[y][x + i] = 1;
				line++;
			}
			
			DFS(idx + 1, coreCnt + 1, lineCnt + line);
			
			for (int i = 1; x + i < N; i++) {
				map[y][x + i] = 0;
			}
		}
	}
}