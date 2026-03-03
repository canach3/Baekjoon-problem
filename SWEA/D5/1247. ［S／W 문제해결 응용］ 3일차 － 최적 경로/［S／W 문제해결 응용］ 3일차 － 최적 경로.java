import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] clientArr;
	static int[] company;
	static int[] home;
	static boolean visited[];
	static int min;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			clientArr = new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 회사 좌표
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			company = new int[] {x, y};
			
			// 집 좌표
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			home = new int[] {x, y};
			
			// 고객 좌표
			for (int i = 0; i < N; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				clientArr[i] = new int[] {x, y};
			}
			
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			perm(0, 0, company[0], company[1]);
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void perm(int idx, int sum, int previousX, int previousY) {
		if (idx == N) {
			sum += Math.abs(previousX - home[0]) + Math.abs(previousY - home[1]);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < clientArr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				
				perm(idx + 1, sum + Math.abs(previousX - clientArr[i][0]) + Math.abs(previousY - clientArr[i][1]), clientArr[i][0], clientArr[i][1]);
				
				visited[i] = false;
			}
		}
	}
}