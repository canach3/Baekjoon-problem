import java.io.*;
import java.util.*;

public class Solution {
	static int D;
	static int W;
	static int K;
	static int[][] map;
	static int[] inject;
	static int min;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			inject = new int[D];
			for (int i = 0; i < D; i++) {
				inject[i] = -1;
			}
			
			min = Integer.MAX_VALUE;
			DFS(0, 0);
				
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}

	static void DFS(int y, int cnt) {
		if (cnt >= K) {
			min = Math.min(min, K);
			return;
		}
		
		if (y == D) {
			// 약품 주입
			int[][] tmp = new int[D][W];
			for (int i = 0; i < D; i++) {
				tmp[i] = Arrays.copyOf(map[i], W);
			}
			
			for (int i = 0; i < D; i++) {
				if (inject[i] != -1) {
					int fill = inject[i];
					for (int j = 0; j < W; j++) {
						tmp[i][j] = fill;
					}
				}
			}
			
			// 테스트
			boolean complete = true;
			
			for (int i = 0; i < W; i++) {
				int feat = tmp[0][i];
				int sameCnt = 1;
				boolean pass = false;
				
				for (int j = 1; j < D; j++) {
					if (tmp[j][i] == feat) sameCnt++;
					else {
						feat = tmp[j][i];
						sameCnt = 1;
					}
					
					if (sameCnt >= K) {
						pass = true;
						break;
					}
				}
				
				if (!pass) {
					complete = false;
					break;
				}
				
			}
			
			// 테스트 성공시 min 업데이트
			if (complete) min = Math.min(min, cnt);
			
			return;
		}
		
		inject[y] = 0;
		DFS(y + 1, cnt + 1);
		
		inject[y] = 1;
		DFS(y + 1, cnt + 1);
		
		inject[y] = -1;
		DFS(y + 1, cnt);
	}
}