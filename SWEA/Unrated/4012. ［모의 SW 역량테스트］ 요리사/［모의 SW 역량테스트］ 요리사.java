import java.io.*;
import java.util.*;
 
public class Solution {
	static int N;
	static int[][] map;
	static boolean[] selectA; 
	static int min;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			selectA = new boolean[N];
			
			DFS(0, 0);
			
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int ingredient, int cnt) {
		if (cnt == N / 2) {
			int sumA = 0;
			int sumB = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					
					if (selectA[i] && selectA[j]) {
						sumA += map[i][j];
					}
					else if (!selectA[i] && !selectA[j]) {
						sumB += map[i][j];
					}
				}
			}
			
			min = Math.min(min, Math.abs(sumA - sumB));
			return;
		}
		
		if (ingredient >= N) return;
		
		selectA[ingredient] = true;
		DFS(ingredient + 1, cnt + 1);
		
		selectA[ingredient] = false;
		DFS(ingredient + 1, cnt);
	}
}