import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static List<int[]> cores;
	
	static int coreMax;
	static int lineMin;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			cores = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) cores.add(new int[] {i, j});
				}
			}

			coreMax = 0;
			lineMin = Integer.MAX_VALUE;
			DFS(0, 0, 0);
		
			sb.append(lineMin).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int core, int coreCnt, int lineCnt) {
		// 종료 조건 : 모든 core 다 확인한 경우
		if (core >= cores.size()) {
			if (coreCnt > coreMax) {
				coreMax = coreCnt;
				lineMin = lineCnt;
			} else if (coreMax == coreCnt) {
				lineMin = Math.min(lineMin, lineCnt);
			}
			
			return;
		}
		
		int coreY = cores.get(core)[0];
		int coreX = cores.get(core)[1];
		
		// 가장자리인 경우
		if (coreX == 0 || coreX == N - 1 || coreY == 0 || coreY == N - 1) {
			DFS(core + 1, coreCnt + 1, lineCnt);
		}
		
		// 가장자리가 아닌 경우
		else {
			// 전원X
			DFS(core + 1, coreCnt, lineCnt);
			
			// 상
			boolean install = true;
			int cnt = 0;
			for (int i = coreY - 1; i >= 0; i--) {
				if (map[i][coreX] == 1) {
					install = false;
					break;
				}
				cnt++;
			}
			
			if (install) {
				for (int i = coreY - 1; i >= 0; i--) map[i][coreX] = 1;
				DFS(core + 1, coreCnt + 1, lineCnt + cnt);
				for (int i = coreY - 1; i >= 0; i--) map[i][coreX] = 0;
			}
			
			// 하
			install = true;
			cnt = 0;
			for (int i = coreY + 1; i < N; i++) {
				if (map[i][coreX] == 1) {
					install = false;
					break;
				}
				cnt++;
			}
			
			if (install) {
				for (int i = coreY + 1; i < N; i++) map[i][coreX] = 1;
				DFS(core + 1, coreCnt + 1, lineCnt + cnt);
				for (int i = coreY + 1; i < N; i++) map[i][coreX] = 0;
			}
			
			// 좌
			install = true;
			cnt = 0;
			for (int i = coreX - 1; i >= 0; i--) {
				if (map[coreY][i] == 1) {
					install = false;
					break;
				}
				cnt++;
			}
			
			if (install) {
				for (int i = coreX - 1; i >= 0; i--) map[coreY][i] = 1;
				DFS(core + 1, coreCnt + 1, lineCnt + cnt);
				for (int i = coreX - 1; i >= 0; i--) map[coreY][i] = 0;
			}
			
			// 우
			install = true;
			cnt = 0;
			for (int i = coreX + 1; i < N; i++) {
				if (map[coreY][i] == 1) {
					install = false;
					break;
				}
				cnt++;
			}
			
			if (install) {
				for (int i = coreX + 1; i < N; i++) map[coreY][i] = 1;
				DFS(core + 1, coreCnt + 1, lineCnt + cnt);
				for (int i = coreX + 1; i < N; i++) map[coreY][i] = 0;
			}
		}
	}
}