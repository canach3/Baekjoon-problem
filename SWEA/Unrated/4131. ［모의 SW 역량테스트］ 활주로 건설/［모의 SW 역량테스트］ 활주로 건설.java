import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#" + testCase + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N + 2][N + 2];
			
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					map[i][j] = 10;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			// 행
			boolean[][] runway = new boolean[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				boolean isPossible = true;
				
				for (int j = 1; j <= N - 1; j++) {
					if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
						isPossible = false;
						break; // 2 이상 차이나면 활주로건설 X
					}
					
					if (map[i][j] == map[i][j + 1]) continue;
					
					// 다음 블록이 1 높은 경우
					if (map[i][j + 1] == map[i][j] + 1) {
						for (int k = 0; k < X; k++) {
							if (map[i][j - k] != map[i][j] || runway[i][j - k]) { // 내 왼쪽 X 만큼이 나랑 같은 높이가 아니거나 해당 블록에 활주로가 이미 설치된 경우
								isPossible = false;
								break;
							}
							
							runway[i][j - k] = true; // 활주로 설치
						}
						
						if (!isPossible) break; // 해당 행 활주로 설치 불가
					}
						
					// 다음 블록이 1 낮은 경우
					else if (map[i][j + 1] == map[i][j] - 1) {
						for (int k = 0; k < X; k++) {
							if (map[i][j + k + 1] != map[i][j + 1] || runway[i][j + k + 1]) { // 내 왼쪽 X 만큼이 나랑 같은 높이가 아니거나 해당 블록에 활주로가 이미 설치된 경우
								isPossible = false;
								break;
							}
							
							runway[i][j + k + 1] = true; // 활주로 설치
						}
						
						if (!isPossible) break; // 해당 행 활주로 설치 불가
					}
				}
				
				// 해당 행이 활주로 건설 가능하면 cnt 증가하기
				if (isPossible)  {
					cnt++;
				}
			}
			
			// 열
			runway = new boolean[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				boolean isPossible = true;
				
				for (int j = 1; j <= N - 1; j++) {
					if (Math.abs(map[j][i] - map[j + 1][i]) > 1) {
						isPossible = false;
						break;
					}
					
					if (map[j][i] == map[j + 1][i]) continue;
					
					if (map[j + 1][i] == map[j][i] + 1) {
						for (int k = 0; k < X; k++) {
							if (map[j - k][i] != map[j][i] || runway[j - k][i]) {  
								isPossible = false;
								break;
							}
							
							runway[j - k][i] = true; 
						}
						
						if (!isPossible) break; 
					}
						
					else if (map[j + 1][i] == map[j][i] - 1) {
						for (int k = 0; k < X; k++) {
							if (map[j + k + 1][i] != map[j + 1][i] || runway[j + k + 1][i]) {
								isPossible = false;
								break;
							}
							
							runway[j + k + 1][i] = true; 
						}
						
						if (!isPossible) break;
					
					}
				}
				
				if (isPossible)  {
					cnt++;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
}