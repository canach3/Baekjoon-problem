import java.io.*;
import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			List<List<Integer>> adjList = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adjList.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				adjList.get(v1).add(v2);
				adjList.get(v2).add(v1);
			}
			
			// 상원이는 초대받는 사람에서 제외해야함
			int cnt = -1;	
			boolean[] visited = new boolean[N + 1];
			
			Deque<int[]> deque = new ArrayDeque<>();
			visited[1] = true;
			deque.addLast(new int[] {1, 0});
			
			while (!deque.isEmpty() && deque.peekFirst()[1] < 3) {
				cnt++; 
				
				int[] tmp = deque.pollFirst();
				int curr = tmp[0]; 
				int depth = tmp[1];
				
				for (int next : adjList.get(curr)) {
					if (!visited[next]) {
						visited[next] = true;
						deque.addLast(new int[] {next, depth + 1});
					}
				}
			}
			
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
}