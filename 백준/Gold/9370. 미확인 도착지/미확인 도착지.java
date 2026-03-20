import java.io.*;
import java.util.*;

public class Main {
	static int N; // 노드(교차로) 개수
	static int M; // 간선(도로) 개수
	static int T; // 목적지 노드 후보의 개수
	static int S; // 출발점
	static int G; // 통과해야되는 정점
	static int H; // 통과해야되는 정점
	
	static List<List<int[]>> adjList;
	static int[][] dist;	// 거리와 자신의 이전노드를 저장
	static int[] target;	// 목적지 후보 저장
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			
			// 인접리스트 초기화
			adjList = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adjList.add(new ArrayList<>());
			}
			
			// 경로저장 배열 초기화
			dist = new int[N + 1][2];
			for (int i = 1; i <= N; i++) {
				dist[i][0] = Integer.MAX_VALUE;
			}
			
			// 목적지후보 배열 초기화
			target = new int[T];
			
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken()) * 2;
				
				if((v1 == G && v2 == H) || (v1 == H && v2 == G)) cost--;
				
				adjList.get(v1).add(new int[] {v2, cost});
				adjList.get(v2).add(new int[] {v1, cost});
			}
			
			for (int i = 0; i < T; i++) {
				target[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(target);
			
			dijkstra();
			
			for (int i = 0; i < T; i++) {
				int finalDist = dist[target[i]][0];
				if (finalDist % 2 != 0 && finalDist != Integer.MAX_VALUE) sb.append(target[i]).append(" ");
			}
			
//			for (int i = 0; i < T; i++) {
//				boolean cross = false;
//				int curr = target[i];
//				
//				while (curr != S) {
//					int prev = dist[curr][1];
//					
//					if ((curr == G && prev == H) || (curr == H && prev == G)) {
//						cross = true;
//						break;
//					}
//					
//					curr = prev;
//				}
//				
//				if (cross) sb.append(target[i]).append(" ");
//			}
			
			sb.append("\n");
		}
			
		System.out.print(sb);
	}
	
	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1],  b[1]));
		dist[S][0] = 0;
		dist[S][1] = S;
		pq.add(new int[] {S, 0});
		
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currV = curr[0];
			int currCost = curr[1];
			
			if (currCost > dist[currV][0]) continue;
			
			for (int[] next : adjList.get(currV)) {
				int nextV = next[0];
				int nextCost = next[1];
				int newCost = currCost + nextCost;
				
				if (newCost < dist[nextV][0]) {
					dist[nextV][0] = newCost;
					dist[nextV][1] = currV;
					
					pq.add(new int[] {nextV, newCost});
				}
			}
		}
	}
}