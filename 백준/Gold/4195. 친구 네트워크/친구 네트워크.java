import java.io.*;
import java.util.*;

public class Main {
	static Map<String, Integer> hashMap;
	static int[] parent;
	static int[] depth;
	static int idx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			int F = Integer.parseInt(br.readLine().trim());
			
			// 변수 초기화
			hashMap = new HashMap<>();
			parent = new int[F * 2 + 1];
			depth = new int[F * 2 + 1];
			for (int i = 0; i < F * 2 + 1; i++) {
				parent[i] = i;
				depth[i] = 1;
			}
			
			idx = -1;
			
			for (int i = 0; i < F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int v1 = vId(st.nextToken());
				int v2 = vId(st.nextToken());
				
				sb.append(union(v1, v2)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static int vId(String input) {
		Integer id = hashMap.get(input); 
        if (id == null) {
            hashMap.put(input, ++idx);
            return idx;
        }
        return id;
	}
	
	static int union(int v1, int v2) {
		int v1Root = find(v1);
		int v2Root = find(v2);
		
		if (v1Root == v2Root) return depth[v1Root];
		
		// depth 추가
		parent[v2Root] = v1Root;
		depth[v1Root] += depth[v2Root];
		
		return depth[v1Root];
	}
	
	static int find(int v) {
		if (parent[v] == v) return v;
		
		return parent[v] = find(parent[v]);
	}
}