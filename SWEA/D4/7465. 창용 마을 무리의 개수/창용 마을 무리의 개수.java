import java.io.*;
import java.util.*;

public class Solution {
	static List<List<Integer>> adjList;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adjList.add(new ArrayList<>());
			}
			
			visited = new boolean[N + 1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				adjList.get(v1).add(v2);
				adjList.get(v2).add(v1);
			}
			
			int cnt = 0;
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					DFS(i);
					cnt++;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int current) {
		visited[current] = true;
		
		for (int next : adjList.get(current)) {
			if (!visited[next]) {
				DFS(next);
			}
		}
	}
}