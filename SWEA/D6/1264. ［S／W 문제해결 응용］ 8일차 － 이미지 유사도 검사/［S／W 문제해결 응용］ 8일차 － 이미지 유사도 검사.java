import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int N = Integer.parseInt(br.readLine().trim());
			
			char[] X = br.readLine().toCharArray();
			char[] Y = br.readLine().toCharArray();
			
			int[][] dp = new int[N + 1][N + 1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (X[i - 1] == Y[j - 1]) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
			
			double result = (double) dp[N][N] / N * 100;
			
			sb.append(String.format("%.2f", result)).append("\n");
		}
		
		System.out.print(sb);
	}
}
