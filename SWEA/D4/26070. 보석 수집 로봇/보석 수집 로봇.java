import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int N = Integer.parseInt(br.readLine().trim());
			int[][] map = new int[N][N];
			int[][] targets = new int[12][2];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (map[i][j] != 0) {
						targets[map[i][j]][0] = j;
						targets[map[i][j]][1] = i;
					}
				}
			}
			
			int[] dx = {0, 0, -1, 1};
			int[] dy = {-1, 1, 0, 0};
			
			int target = 1; // 첫 번째 보석
			int cnt = 0;
			int direction = 3; // 우
			int rx = 0;
			int ry = 0;
			
			while(true) {
				// 타깃 위치 확인
				int tx = targets[target][0];
				int ty = targets[target][1];
				
				// 타깃의 좌표가 (0, 0) 이면 종료
				if (tx == 0 && ty == 0) break;
				
				// 내 위치에 보석이 있으면 먹고 다음 보석으로 업데이트
				if (rx == tx && ry == ty) {
					target++;
					continue;
				}
				
				// 타깃의 위치와 내 위치 + 방향을 비교해서 명령 수행
				if (direction == 0) { // 상
					// 하, 우 : 턴
					if (ry < ty || (ry == ty && rx < tx)) {
						direction = 3;
						cnt++;
					} 
				}
				
				else if (direction == 1) { // 하
					// 상, 좌 : 턴
					if (ry > ty || (ry == ty && rx > tx)) {
						direction = 2;
						cnt++;
					} 			
				}
				
				else if (direction == 2) { // 좌
					// 상, 우 : 턴
					if (rx < tx || (rx == tx && ry > ty)) {
						direction = 0;
						cnt++;
					}
				}
				
				else if (direction == 3) { // 우
					// 하, 좌 : 턴
					if (rx > tx || (rx == tx && ry < ty)) {
						direction = 1;
						cnt++;
					}
				}
				
				rx += dx[direction];
				ry += dy[direction];
			}
			
			sb.append(cnt).append("\n");
		}
	
		System.out.print(sb);
	}
}