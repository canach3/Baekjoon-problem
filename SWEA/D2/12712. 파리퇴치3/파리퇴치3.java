import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};
		int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};

		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = map[i][j];
					
					for (int k = 1; k < M; k++) {
						for (int l = 0; l < 4; l++) {
							int nextY = i + dy[l] * k;
							int nextX = j + dx[l] * k;
							
							if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N) {
								sum += map[nextY][nextX];
							}
						}
					}
					
					if (sum > max) max = sum;
					
					sum = map[i][j];
					for (int k = 1; k < M; k++) {
						for (int l = 4; l < 8; l++) {
							int nextY = i + dy[l] * k;
							int nextX = j + dx[l] * k;
							
							if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N) {
								sum += map[nextY][nextX];
							}
						}
					}
					
					if (sum > max) max = sum;
				}
			}
			
			
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		
		System.out.print(sb);
	}
}