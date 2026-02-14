import java.io.*;
import java.util.*;
 
public class Solution {
	static int N;
	static int[] operands;
	static int max;
	static int min;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			
			operands = new int[N];
			int[] operators = new int[4];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operators[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				operands[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < 4; i++) {
				if (operators[i] != 0) {
					int[] tmpOperators = new int[4];
					tmpOperators = Arrays.copyOf(operators, 4);
					tmpOperators[i]--;
					
					DFS(tmpOperators, operands[0], i, 1);
				}
			}
			
			sb.append(max - min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int[] operators, int result, int operator, int next) {
		switch (operator) {
			case 0:
				result += operands[next];
				break;
			case 1:
				result -= operands[next];
				break;
			case 2:
				result *= operands[next];
				break;
			case 3:
				result /= operands[next];
				break;
		}
		
		if (next >= N - 1) {
			if (result < min) min = result;
			if (result > max) max = result;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operators[i] != 0) {
				int[] tmpOperators = new int[4];
				tmpOperators = Arrays.copyOf(operators, 4);
				tmpOperators[i]--;
				
				DFS(tmpOperators, result, i, next + 1);
			}
		}
	}
}