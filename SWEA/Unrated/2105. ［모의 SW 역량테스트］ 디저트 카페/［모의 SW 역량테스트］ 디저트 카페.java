import java.io.*;
import java.util.*;
 
public class Solution {
	static int map[][];
	static int max;
	static List<Integer> visited;
	static int dx[] = {1, -1, -1, 1, 0};
	static int dy[] = {1, 1, -1, -1, 0};
	
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
					DFS(i, j, i, j, 0); // 시계방향으로 돌기
				}
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int sY, int sX, int cY, int cX, int level) {
		// 출발점에 다시 돌아온 경우
		if (cY == sY && cX == sX && level == 3) {
			max = Math.max(max, visited.size());
			return;
		}
		
		int cafe = map[cY][cX];
		
		// 이미 방문했던 곳이거나 타일 숫자가 0이거나 범위를 벗어난 경우
		if (cafe == 0 || visited.contains(cafe) || level == 4) return;
		
			visited.add(cafe);
			DFS(sY, sX, cY + dy[level], cX + dx[level], level); // 직진
			visited.remove(visited.size() - 1); 
			
			visited.add(cafe);
			DFS(sY, sX, cY + dy[level + 1], cX + dx[level + 1], level + 1); // 꺾기
			visited.remove(visited.size() - 1);
	}
}