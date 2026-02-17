import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int B;
	static int [] arr;
	static int min;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			DFS(0, 0);
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int idx, int sum) {
		if (sum >= B) {
			min = Math.min(min, sum - B);
			return;
		}
		
		if (idx >= N) return;
		
		DFS(idx + 1, sum);
		DFS(idx + 1, sum + arr[idx]);
	}
}