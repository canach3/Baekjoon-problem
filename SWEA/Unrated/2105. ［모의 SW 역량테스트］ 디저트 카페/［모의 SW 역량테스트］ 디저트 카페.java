import java.io.*;
import java.util.*;
 
public class Solution {
	static int map[][];
	static int max;
	static List<Integer> visited;
	
	static int cw_x[] = {1, -1, -1, 1, 0};
	static int cw_y[] = {1, 1, -1, -1, 0};
	static int ccw_x[] = {-1, 1, 1, -1, 0};
	static int ccw_y[] = {1, 1, -1, -1, 0};
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int N = Integer.parseInt(br.readLine().trim());
			map = new int[N + 2][N + 2];
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new ArrayList<>();
			max = -1;
			
			for (int i = 1; i <= N - 1; i++) {
				for (int j = 2; j <= N - 1; j++) {
					DFS(i, j, i, j, true, 0); // 시계방향으로 돌기
					DFS(i, j, i, j, false, 0); // 반시계방향으로 돌기
				}
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int sY, int sX, int cY, int cX, boolean clockWise, int level) {
		// 출발점에 다시 돌아온 경우
		if (cY == sY && cX == sX && level == 3) {
			max = Math.max(max, visited.size());
			return;
		}
		
		int cafe = map[cY][cX];
		
		// 이미 방문했던 곳이거나 타일 숫자가 0이거나 범위를 벗어난 경우
		if (cafe == 0 || visited.contains(cafe) || level == 4) return;
		
		// 시계방향인 경우
		if (clockWise) {
			visited.add(cafe);
			DFS(sY, sX, cY + cw_y[level], cX + cw_x[level], true, level); // 직잔
			visited.remove(visited.size() - 1); 
			
			visited.add(cafe);
			DFS(sY, sX, cY + cw_y[level + 1], cX + cw_x[level + 1], true, level + 1); // 꺾기
			visited.remove(visited.size() - 1);
		} 
		
		// 반시계방향인 경우
		else {
			visited.add(cafe);
			DFS(sY, sX, cY + ccw_y[level], cX + ccw_x[level], false, level); // 직진
			visited.remove(visited.size() - 1);
			
			visited.add(cafe);
			DFS(sY, sX, cY + ccw_y[level + 1], cX + ccw_x[level + 1], false, level + 1); // 꺾기
			visited.remove(visited.size() - 1);
		}
	}
}