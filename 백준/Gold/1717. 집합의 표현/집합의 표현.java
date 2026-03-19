import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			if (command == 0) union(v1, v2);
			else {
				if (isConnected(v1, v2)) {
					sb.append("YES");
				} else {
					sb.append("NO");
				}
				
				sb.append("\n");
			}
		}
		
		System.out.print(sb);
	}
	
	static void union(int v1, int v2) {
		int v1Root = find(v1);
		int v2Root = find(v2);
		
		parent[v2Root] = v1Root;
	}
	
	static int find(int v) {
		if (parent[v] == v) return v;
		
		return parent[v] = find(parent[v]);
	}
	
	static boolean isConnected(int v1, int v2) {
		int v1Root = find(v1);
		int v2Root = find(v2);
		
		if (v1Root == v2Root) return true;
		return false;
	}
}