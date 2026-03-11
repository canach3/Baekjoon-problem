import java.io.*;
import java.util.*;
 
public class Solution {
	static int N;
	static int X;
	static int M;
	static List<int[]> commands;
	
	static int max;
	static boolean isPossible;
	static int[] result;

	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			commands = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				commands.add(new int[] {Integer.parseInt(st.nextToken()), 
										Integer.parseInt(st.nextToken()), 
										Integer.parseInt(st.nextToken())});
			}
																
			max = 0;
			isPossible = false;
			result = new int[N + 1];
			
			DFS(1, new int[N + 1]);
			
			if (isPossible) {
				for (int i = 1; i <= N; i++) {
					sb.append(result[i]).append(" ");
				}
			} else {
				sb.append(-1);
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int idx, int[] arr) {
		if (idx > N) {
			// 누적합 구하기
			int[] sumArr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				sumArr[i] = sumArr[i - 1] + arr[i];
			}
			
			boolean isOk = true;
			
			// 현재 결과가 조건들에 부합하는지 확인 (정답이 되는지)
			for (int i = 0; i < M; i++) {
				int left = commands.get(i)[0];
				int right = commands.get(i)[1];
				int amount = commands.get(i)[2];
				
				if (sumArr[right] - sumArr[left - 1] != amount) {
					isOk = false;
					break;
				}
			}

			// 정답으로 불가능한 경우
			if (!isOk) return;
			
			// 정답으로 가능한 경우
			// 우선순위 1 : 햄스터 수가 가장 많은 것
			if (sumArr[N] > max) {
				if (sumArr[N] > max) {
					max = sumArr[N];
					result = Arrays.copyOf(arr, N + 1);
				}
				
				// 우선순위 2 : 사전 순으로 앞선 것
				else if (sumArr[N] == max) {
					boolean win = false;
					
					for (int i = 1; i <= N; i++) {
						if (arr[i] < result[i]) {
							win = true;
							break;
						}
					}
					
					if (win) result = Arrays.copyOf(arr, N + 1);
				}
			}

			isPossible = true;
			return;
		}
		
		for (int i = 0; i <= X; i++) {
			arr[idx] = i;
			DFS(idx + 1, arr);
		}
	}
}