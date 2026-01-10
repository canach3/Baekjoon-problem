import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			char[][] map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String input = st.nextToken();
				char[] line = input.toCharArray();
				
				for (int j = 0; j < N; j++) {
					map[i][j] = line[j];
				}
			}

			boolean omok = false;
			
			// 가로
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'o') {
						cnt++;
						
						if (cnt >= 5 ) {
							omok = true;
							break;
						}
					} else {
						cnt = 0;
					}
				}
				
				if (omok) {
					break;
				}
			}
			
			// 세로
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				
				for (int j = 0; j < N; j++) {
					if (map[j][i] == 'o') {
						cnt++;
						
						if (cnt >= 5 ) {
							omok = true;
							break;
						}
					} else {
						cnt = 0;
					}
				}
				
				if (omok) {
					break;
				}
			}
			
			// 대각선(위아래)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					
					for (int k = 0; k < 5; k++) {
						if ((i + k) < N && (j + k) < N) {
							if (map[i + k][j + k] == 'o') {
								cnt++;
							}
						}
					}
						
					if (cnt == 5) {
						omok = true;
						break;
					}
				}
					
				if (omok) {
					break;
				}
			}
			
			// 대각선(아래위)
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					
					for (int k = 0; k < 5; k++) {
						if ((i - k) >= 0 && (j + k) < N) {
							if (map[i - k][j + k] == 'o') {
								cnt++;
							}
						}
					}
						
					if (cnt == 5) {
						omok = true;
						break;
					}
				}
					
				if (omok) {
					break;
				}
			}
			
			
			if (omok) {
				System.out.println("#" + testCase + " YES");
			} else {
				System.out.println("#" + testCase + " NO");
			}
		}
	}
}