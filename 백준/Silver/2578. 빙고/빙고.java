
import java.util.*;
import java.io.*;

public class Main {
	static boolean bingo3;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (!bingo3) {
					cnt++;
					
					for (int k1 = 0; k1 < 5; k1++) {
						for (int k2 = 0; k2 < 5; k2++) {
							if (map[k1][k2] == num) {
								map[k1][k2] = 0;
							}
						}
					}
					
					check();
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static void check() {
		int bingoCnt = 0;
		
		// 가로
		for (int i = 0; i < 5; i++) {
			boolean bingo = true;
			for (int j = 0; j < 5; j++) {
				if (map[i][j] != 0) {
					bingo = false;
					break;
				}
			}
			
			if (bingo) {
				bingoCnt++;
			}
		}
		
		// 세로
		for (int i = 0; i < 5; i++) {
			boolean bingo = true;
			for (int j = 0; j < 5; j++) {
				if (map[j][i] != 0) {
					bingo = false;
					break;
				}
			}
			
			if (bingo) {
				bingoCnt++;
			}
		}
		
		// 대각선
		for (int i = 0; i < 5; i++) {
			if (map[i][i] != 0) {
				break;
			}
			
			if (i == 4) {
				bingoCnt++;
			}
		}
		
		for (int i = 4; i >= 0; i--) {
			if (map[i][4-i] != 0) {
				break;
			}
			
			if (i == 0) {
				bingoCnt++;
			}
		}
		
		
		if (bingoCnt >= 3) {
			bingo3 = true;
		}
	}
}