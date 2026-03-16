import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static char[][] map;
	
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		int rY = 0;
		int rX = 0;
		int bY = 0;
		int bX = 0;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				
				if (map[i][j] == 'R') {
					rY = i;
					rX = j;
				}
				
				if (map[i][j] == 'B') {
					bY = i;
					bX = j;
				}
				
//				if (map[i][j] == 'O') {
//					holeY = i;
//					holeX = j;
//				}
			}
		}
		
		int min = BFS(rY, rX, bY, bX);
		
		System.out.println(min);
	}
	
	static int BFS(int s_rY, int s_rX, int s_bY, int s_bX) {
		Deque<int[]> deque = new ArrayDeque<>();
		
		// 시계 방향으로 '시도' 큐에 넣기
		deque.addLast(new int[] {s_rY, s_rX, s_bY, s_bX, 0, 0});
		
		while (deque.peekFirst()[5] < 10) { // 10회가 지나면 종료
			int[] temp = deque.pollFirst();
			int rY = temp[0];
			int rX = temp[1];
			int bY = temp[2];
			int bX = temp[3];
			int direction = temp[4];
			int time = temp[5];
			
			// 4 방향으로 굴리기(상우하좌)
			for (int i = 1; i <= 4; i++) {
				// 해당 방향으로 굴릴 수 있는 지 확인 (이전에 굴린 방향과 동일한 방향은 시도X)
				if (direction == i) continue;
				
				int[] rResult = new int[2];
				int[] bResult = new int[2];
				
				// 상
				if (i == 1) {
					if (bY < rY) { // 파란공 먼저 굴리기
						bResult = rolling(bY, bX, i, false);
						rResult = rolling(rY, rX, i, true);
					} else {	   // 빨간공 먼저 굴리기
						rResult = rolling(rY, rX, i, true);
						bResult = rolling(bY, bX, i, false);
					}
				}
				
				// 우
				if (i == 2) {
					if (bX > rX) { // 파란공 먼저 굴리기
						bResult = rolling(bY, bX, i, false);
						rResult = rolling(rY, rX, i, true);
					} else {	   // 빨간공 먼저 굴리기
						rResult = rolling(rY, rX, i, true);
						bResult = rolling(bY, bX, i, false);
					}
				}
				
				
				// 하
				if (i == 3) {
					if (bY > rY) { // 파란공 먼저 굴리기
						bResult = rolling(bY, bX, i, false);
						rResult = rolling(rY, rX, i, true);
					} else {	   // 빨간공 먼저 굴리기
						rResult = rolling(rY, rX, i, true);
						bResult = rolling(bY, bX, i, false);
					}
				}
				
				
				// 좌
				if (i == 4) {
					if (bX < rX) { // 파란공 먼저 굴리기
						bResult = rolling(bY, bX, i, false);
						rResult = rolling(rY, rX, i, true);
					} else {	   // 빨간공 먼저 굴리기
						rResult = rolling(rY, rX, i, true);
						bResult = rolling(bY, bX, i, false);
					}
				}
				
				// 파란공이 들어간 경우
				if (bResult[0] == -1) {
					if (rResult[0] != -1) {
						map[rResult[0]][rResult[1]] = '.';
					}
					
					map[rY][rX] = 'R';
					map[bY][bX] = 'B';
					continue;
				}
				
				// 빨간공이 들어간 경우
				if (rResult[0] == -1) return time + 1;
				
				// 공이 안 들어간 경우
				deque.addLast(new int[] {rResult[0], rResult[1], bResult[0], bResult[1], i, time + 1});
				
				// 구슬 위치 원상복구
				map[rResult[0]][rResult[1]] = '.';
				map[bResult[0]][bResult[1]] = '.';
				
				map[rY][rX] = 'R';
				map[bY][bX] = 'B';
			}
			
			map[rY][rX] = '.';
			map[bY][bX] = '.';
		}
		
		return -1;
	}
	
	static int[] rolling(int y, int x, int d, boolean isRed) {
		// 현재 자리 . 으로 바꾸기
		map[y][x] = '.';
		
		while (map[y][x] == '.') {
			
			// 한 칸 이동
			y += dy[d];
			x += dx[d];
		}
		
		// 구멍에 들어가는 경우
		if (map[y][x] == 'O') return new int[] {-1, -1};
		
		int pY = y - dy[d];
		int pX = x - dx[d];
		
		if (isRed) {
			map[pY][pX] = 'R';
		} else {
			map[pY][pX] = 'B';	
		}
		
		return new int[] {pY, pX};
	}
}