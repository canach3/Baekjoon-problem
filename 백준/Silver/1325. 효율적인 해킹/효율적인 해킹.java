import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
		for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            
            adjList[v1].add(v2);
        }
		
		int[] cnt = new int[N + 1];
		int[] visited = new int[N + 1];
		int[] queue = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			int head = 0;
            int tail = 0;
            
            queue[tail++] = i;
			visited[i] = i;
			
			while (head < tail) {
				int curr = queue[head++];
				
				ArrayList<Integer> edges = adjList[curr];
                int size = edges.size();
                for (int j = 0; j < size; j++) {
                    int next = edges.get(j);
                    
                    // 방문 배열 초기화 없이, 현재 회차(i)와 다르면 미방문으로 취급!
                    if (visited[next] != i) {
                        visited[next] = i;
                        cnt[next]++;
                        queue[tail++] = next;
                    }
                }
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) max = Math.max(max,  cnt[i]);
		
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == max) sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
}