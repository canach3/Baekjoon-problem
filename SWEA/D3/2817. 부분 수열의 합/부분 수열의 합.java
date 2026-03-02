import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int K;
	static int[] arr;
	static int cnt;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			DFS(0, 0);
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int idx, int sum) {
		if (idx == N) {
			if (sum == K) cnt++;
			return;
		}
		
		DFS(idx + 1, sum);
		DFS(idx + 1, sum + arr[idx]);
	}
}