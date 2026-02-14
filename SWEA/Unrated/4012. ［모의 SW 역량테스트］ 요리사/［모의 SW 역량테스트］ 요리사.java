import java.io.*;
import java.util.*;
 
public class Solution {
	static int N;
	static int[][] map;
	static int[] selectA;
	static int min;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#" + testCase + " ");
			
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = 1000000;
			
			selectA = new int[N];
			DFS(0, 0);
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int ingredient, int cnt) {
		if (cnt == N / 2) {
			int sumA = 0;
			int sumB = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (selectA[i] == 1 && selectA[j] == 1) {
						sumA += map[i][j];
					}
					
					if (selectA[i] == 0 && selectA[j] == 0) {
						sumB += map[i][j];
					}
				}
			}
			
			if (Math.abs(sumA - sumB) < min) min = Math.abs(sumA - sumB);
			return;
		}
		
		if (ingredient >= N) return;
		
		selectA[ingredient] = 1;
		DFS(ingredient + 1, cnt + 1);
		
		selectA[ingredient] = 0;
		DFS(ingredient + 1, cnt);
	}
}