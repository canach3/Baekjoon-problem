import java.io.*;
import java.util.*;
 
public class Solution {
	static int[][] magnets;
	static int[][] mIdxs;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int K = Integer.parseInt(br.readLine().trim());
			
			magnets = new int[5][8]; // 자석들의 정보를 저장하는 배열(자석 4개, 8개 날)
			mIdxs = new int[5][3]; // 자석 날의 인덱스를 저장하는 배열(왼쪽날, 오른쪽날, 화살표날)
			
			for (int i = 1; i <= 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnets[i][j] = Integer.parseInt(st.nextToken());
					
					if (j == 0) mIdxs[i][2] = j;
					else if (j == 2) mIdxs[i][1] = j;
					else if (j == 6) mIdxs[i][0] = j;
				}
			}
			
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
					
				if (m == 1) moveRight(m + 1, d);
				else if (m == 4) moveLeft(m - 1, d);
				else { 
					moveLeft(m - 1, d);
					moveRight(m + 1, d);
				}
				
				moveMiddle(m, d);
			}					
					
			int sum = 0;
			sum += magnets[1][mIdxs[1][2]] == 0 ? 0 : 1;
			sum += magnets[2][mIdxs[2][2]] == 0 ? 0 : 2;
			sum += magnets[3][mIdxs[3][2]] == 0 ? 0 : 4;
			sum += magnets[4][mIdxs[4][2]] == 0 ? 0 : 8;
			
			sb.append(sum).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void moveMiddle(int m, int d) {
		mIdxs[m][0] = (mIdxs[m][0] - d + 8) % 8;
		mIdxs[m][1] = (mIdxs[m][1] - d + 8) % 8;
		mIdxs[m][2] = (mIdxs[m][2] - d + 8) % 8;
	}
	
	static void moveLeft(int m, int right_d) {
		if (m <= 0) return;
		
		// 내 우측날과 오른쪽 자석의 좌측날 비교
		if (magnets[m][mIdxs[m][1]] != magnets[m + 1][mIdxs[m + 1][0]]) {
			moveLeft(m - 1, -right_d);
			moveMiddle(m, -right_d);
		}
	}
	
	static void moveRight(int m, int left_d) {
		if (m >= 5) return;
		
		// 내 좌측날과 왼쪽 자석의 우측날 비교
		if (magnets[m][mIdxs[m][0]] != magnets[m - 1][mIdxs[m - 1][1]]) {
			moveRight(m + 1, -left_d);
			moveMiddle(m, -left_d);
		}
	}
}