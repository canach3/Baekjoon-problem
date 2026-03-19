import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int[] partyInfo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
		
		// 진실을 아는 사람 중 대표를 설정해서, 해당 대표를 root로 설정
		int reputation = 0;
		
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < num; i++) {
			int p = Integer.parseInt(st.nextToken());
			if (i == 0) reputation = p;
			
			parent[p] = reputation;
		}
		
		partyInfo = new int[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int participants = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			partyInfo[i] = first;
			
			for (int j = 0; j < participants - 1; j++) {
				int participant = Integer.parseInt(st.nextToken());
				union(first, participant);
			}
		}
		
		int cnt = 0;
		int v1Root = find(reputation);
		for (int i = 0; i < M; i++) {	
			int v2Root = find(partyInfo[i]);
			
			if (v1Root != v2Root) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static void union(int v1, int v2) {
		int v1Root = find(v1);
		int v2Root = find(v2);
		
		if (v1Root != v2Root) {
			parent[v2Root] = v1Root;
		}
	}
	
	static int find(int v) {
		if (parent[v] == v) return v;
		
		return parent[v] = find(parent[v]);
	}
}