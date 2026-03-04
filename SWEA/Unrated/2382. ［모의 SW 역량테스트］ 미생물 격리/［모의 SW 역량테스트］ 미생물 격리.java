import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dy = {0, -1, 1, 0, 0};
		int[] dx = {0, 0, 0, -1, 1};
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Deque<Hatchery>[][] map = new Deque[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = new ArrayDeque<>();
				}
			}
			
			Deque<Hatchery> deque = new ArrayDeque<>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int amount = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				
				deque.add(new Hatchery(y, x, amount, direction));
			}
			
			int time = 1;
			while(time <= M) {
				
				// 현존하는 군집 처리
				while (!deque.isEmpty()) {
					Hatchery h = deque.pollFirst();
					
					// 해당 방향으로 이동
					h.y = h.y + dy[h.direction];
					h.x = h.x + dx[h.direction];
					
					// 세스코 체크 (1/2 만큼 감소 후, 방향 전환)
					if (h.y == 0 || h.y == N - 1 || h.x == 0 || h.x == N - 1) {
						h.amount /= 2;
						
						if (h.direction == 1) h.direction = 2;
						else if (h.direction == 2) h.direction = 1;
						else if (h.direction == 3) h.direction = 4;
						else if (h.direction == 4) h.direction = 3;
					}
					
					// 현재 위치한 타일의 큐에 집어넣기
					map[h.y][h.x].addLast(h);
				}
				
				// 각 타일별 겹치는 군집 처리
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						
						// 해당 타일에 군집이 존재하는 경우
						if (!map[i][j].isEmpty()) {
							
							// 군집이 하나만 존재하는 경우 -> 그냥 큐에 넣기
							if (map[i][j].size() == 1) {
								deque.addLast(map[i][j].pollFirst());
								continue;
							}
							
							// 군집이 여러개 존재하는 경우 -> 합치고 큐에 넣기
							int max = 0;
							int direction = 0;
							int sum = 0;
							while(!map[i][j].isEmpty()) {
								Hatchery h = map[i][j].pollFirst();
								
								sum += h.amount;
								if (h.amount > max) {
									max = h.amount;
									direction = h.direction;
								}
							}
							
							deque.addLast(new Hatchery(i, j, sum, direction));
						}
					}
				}
				
				time++;
			}
			
			int sum = 0;
			while (!deque.isEmpty()) {
				sum += deque.pollFirst().amount;
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static class Hatchery implements Comparable<Hatchery> {
		int y;
		int x;
		int amount;
		int direction;
		
		Hatchery(int y, int x, int amount, int direction) {
			this.y = y;
			this.x = x;
			this.amount = amount;
			this.direction = direction;
		}
		
		@Override
		public int compareTo(Hatchery o) {
			return Integer.compare(this.amount, o.amount);
		}
	}
}