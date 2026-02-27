import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int M;
	static int C;
	static int[][] map;
	static List<int[]> honeyList;
	static int max;
	static int result;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			honeyList = new ArrayList<>();
			
			// 모든 경우의 벌꿀통을 다 계산하기 : 시작 인덱스, 끝 인덱스, 해당 범위 수익
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					max = 0;
					getHoney(i, j, 0, 0, 0);
					honeyList.add(new int[] {i, j, max}); // M만쿰 범위 내에서 가장 수익이 많은 경우 저장(벌통 y 인덱스, 벌통 x 인덱스, 수익)
				}
			}
			
			// 모든 경우의 수 중에서 수익이 최대가 되는 것 두 개 고르기
			result = 0;
			select(null, 0);
			
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void getHoney(int y, int x, int idx, int sum, int profit) {
		if (sum > C) return;
		
		if (idx <= M) {
			max = Math.max(max, profit);
			
			if (idx == M) return;
		}
		
		getHoney(y, x, idx + 1, sum, profit);
		getHoney(y, x, idx + 1, sum + map[y][x + idx], (int) (profit + Math.pow(map[y][x + idx], 2)));
	}
	
	static void select(int[] honeyA, int idx) {
		if (idx >= honeyList.size()) return;
		
		if (honeyA == null) { // A를 고르는 경우
			select(honeyA, idx + 1);
			
			honeyA = honeyList.get(idx);
			select(honeyA, idx + 1);
		} else {			  // B를 고르는 경우
			select(honeyA, idx + 1);
			
			int[] honeyB = honeyList.get(idx);
			if (honeyA[0] == honeyB[0] && honeyA[1] + M >= honeyB[1]) return; // 벌꿀통 범위가 겹치면 return
			
			result = Math.max(result, honeyA[2] + honeyB[2]);
		}
	}
}