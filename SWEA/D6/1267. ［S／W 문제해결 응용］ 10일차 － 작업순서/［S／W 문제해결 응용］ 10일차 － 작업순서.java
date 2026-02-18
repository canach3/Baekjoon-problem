import java.io.*;
import java.util.*;

public class Solution {
	static List<List<Integer>> adjList;
	static int time;
	static int[][] nodeTime; // 각 노드를 방문한 시간을 저장하는 배열(discover time, finish time)
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList<>();
			nodeTime = new int[V + 1][3];
			
			for (int i = 0; i <= V; i++) {
				adjList.add(new ArrayList<>());
				nodeTime[i][0] = i;
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				adjList.get(start).add(end);
			}
			
			time = 1;
			for (int i = 1; i <= V; i++) {
				if(nodeTime[i][1] == 0) DFS(i);
			}
			
			Arrays.sort(nodeTime, (o1, o2) -> {
				return Integer.compare(o2[2], o1[2]);
			});
			
			for (int i = 0; i < V; i++) {
				sb.append(nodeTime[i][0]).append(" ");
			}
			
			sb.append("\n");
		}
				
		System.out.print(sb);
	}
	
	static void DFS(int current) {
		nodeTime[current][1] = time++;
		
		for (int i = 0; i < adjList.get(current).size(); i++) {
			int next = adjList.get(current).get(i);
			if (nodeTime[next][1] == 0) DFS(next);
		}
		
		nodeTime[current][2] = time++;
	}
}