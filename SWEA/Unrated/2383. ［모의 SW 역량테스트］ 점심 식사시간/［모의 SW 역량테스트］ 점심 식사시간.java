import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	
	static List<int[]> people;
	static int[][] stairs;
	
	static List<Integer> select1;
	static List<Integer> select2;
	static int min;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			
			people = new ArrayList<>();
			stairs = new int[2][3];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (map[i][j] == 1) {
						people.add(new int[] {i ,j});
					}
					
					if (map[i][j] > 1) {
						if (stairs[0][2] == 0) {
							stairs[0][0] = i;
							stairs[0][1] = j;
							stairs[0][2] = map[i][j];
						} else {
							stairs[1][0] = i;
							stairs[1][1] = j;
							stairs[1][2] = map[i][j];
						}
					}
				}
			}
			
			select1 = new ArrayList<>();
			select2 = new ArrayList<>();
			min = Integer.MAX_VALUE;
			DFS(0);
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}
	static void DFS(int pIdx) {
		if (pIdx == people.size()) {
			List<Integer> tmp1 = new ArrayList<>(select1);
			List<Integer> tmp2 = new ArrayList<>(select2);
			Collections.sort(tmp1);
			Collections.sort(tmp2);
			
			for (int i = 0; i < tmp1.size() - 3; i++) {
				if(tmp1.get(i) + stairs[0][2] > tmp1.get(i + 3)) {
					tmp1.set(i + 3, tmp1.get(i) + stairs[0][2]);
				}
			}
			
			for (int i = 0; i < tmp2.size() - 3; i++) {
				if(tmp2.get(i) + stairs[1][2] > tmp2.get(i + 3)) {
					tmp2.set(i + 3, tmp2.get(i) + stairs[1][2]);
				}
			}
			
			int time1 = tmp1.isEmpty() ? 0 : tmp1.get(tmp1.size() - 1) + stairs[0][2];
			int time2 = tmp2.isEmpty() ? 0 : tmp2.get(tmp2.size() - 1) + stairs[1][2];
			
			int totalTime = Math.max(time1, time2);
			min = Math.min(min, totalTime);
			
			return;
		}
		
		int moveTime = Math.abs(people.get(pIdx)[0] - stairs[0][0]) + Math.abs(people.get(pIdx)[1] - stairs[0][1]) + 1;
		select1.add(moveTime);
		DFS(pIdx + 1);
		select1.remove(select1.size() - 1);
		
		moveTime = Math.abs(people.get(pIdx)[0] - stairs[1][0]) + Math.abs(people.get(pIdx)[1] - stairs[1][1]) + 1;
		select2.add(moveTime);
		DFS(pIdx + 1);
		select2.remove(select2.size() - 1);
	}
}