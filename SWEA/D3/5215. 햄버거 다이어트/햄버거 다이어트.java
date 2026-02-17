import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int L;
	static int[][] ingredients;
	static int max;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			ingredients = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken());
				ingredients[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			DFS(0, 0, 0);
			
			sb.append(max).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int ingredient, int totalS, int totalK) {
		if (ingredient >= N) return;
		
		// 해당 재료를 선택하지 않은 경우
		DFS(ingredient + 1, totalS, totalK);
		
		// 해당 재료를 선택한 경우
		totalS += ingredients[ingredient][0];
		totalK += ingredients[ingredient][1];
		
		if (totalK > L) return;
		max = Math.max(totalS, max);
		
		DFS(ingredient + 1, totalS, totalK);
	}
}