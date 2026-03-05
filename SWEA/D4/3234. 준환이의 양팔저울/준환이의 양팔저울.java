import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] arr;
	static boolean visited[];
	static int cnt;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[N];
			cnt = 0;
			perm(0, 0, 0);

			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void perm(int idx, int leftSum, int rightSum) {
		// left < right 인 경우 종료
		if (leftSum < rightSum) return;
		
		// 종료 조건 : 모든 순서 결정
		if (idx == N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				
				perm(idx + 1, leftSum + arr[i], rightSum);
				perm(idx + 1, leftSum, rightSum + arr[i]);
				
				visited[i] = false;
			}
		}
	}
}