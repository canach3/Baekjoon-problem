import java.io.*;
import java.util.*;

public class Solution {
	static int V;
	static int E;
	static List<int[]> edgeList;
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			parent = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parent[i] = i;
			}
			
			edgeList = new ArrayList<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				edgeList.add(new int[] {v1, v2, cost});
			}
			
			Collections.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
			
			long sum = 0;
			int cnt = 0;
			
			for (int[] edge : edgeList) {
				if (cnt == V - 1) break;
				
				int v1 = edge[0];
				int v2 = edge[1];
				int cost = edge[2];
				
				int v1Root = findRoot(v1);
				int v2Root = findRoot(v2);
				
				if (v1Root != v2Root) {
					parent[v2Root] = v1Root;
					sum += cost;
					cnt++;
				}
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static int findRoot(int v) {
		if (parent[v] == v) return v;
		
		return parent[v] = findRoot(parent[v]);
	}
}