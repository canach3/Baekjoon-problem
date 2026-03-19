import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int T;
	static Map<Integer, List<Integer>> homs; // 홈 정보
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		homs = new HashMap<>();
		
		// 0, 0 초기위치 세팅
		homs.put(0, new ArrayList<>());
		homs.get(0).add(0);
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (homs.get(y) == null) {
				List<Integer> list = new ArrayList<>();
				list.add(x);
				homs.put(y, list);
			} else {
				homs.get(y).add(x);
			}
		}
		
		// BFS
		Deque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[] {0, 0, 0}); // {y, x, cnt} 
		
		int result = 0;
		while(!deque.isEmpty()) {
			int[] hom = deque.pollFirst();
			int y = hom[0];
			int x = hom[1];
			int cnt = hom[2];
			
			if (y == T) {
				result = cnt;
				break;
			}
			
			for (int i = y - 2; i <= y + 2; i++) {
				// 상하 2칸 내에 홈이 존재하는 지 확인
				if (homs.get(i) == null) continue;
				
				List<Integer> xList = homs.get(i);

				for (int j = xList.size() - 1; j >= 0; j--) {
					int nextY = i;
					int nextX = xList.get(j);
					
					if (Math.abs(x - nextX) <= 2) {
						deque.addLast(new int[] {nextY, nextX, cnt + 1});
						
						// 방문했으면 리스트에서 지우기 (swap 활용)
						xList.set(j, xList.get(xList.size() - 1));
						xList.remove(xList.size() - 1);
					}
				}
			}
		}
		
		if (result == 0) result = -1;
		
		System.out.println(result);
	}
}