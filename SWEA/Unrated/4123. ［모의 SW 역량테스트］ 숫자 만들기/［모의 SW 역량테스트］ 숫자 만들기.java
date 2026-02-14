import java.io.*;
import java.util.*;
 
public class Solution {
	static int N;
	static int[] operands;
	static int[] operators;
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
			operators = new int[4];
			
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
			
			DFS(1, operands[0]);
			
			sb.append(max - min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int idx, int result) {
		if (idx == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
		
		for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0:
                    	DFS(idx + 1, result + operands[idx]);
                        break;
                    case 1:
                    	DFS(idx + 1, result - operands[idx]);
                        break;
                    case 2:
                    	DFS(idx + 1, result * operands[idx]);
                        break;
                    case 3:
                    	DFS(idx + 1, result / operands[idx]);
                        break;
                }

                operators[i]++;
            }
        }
	}
}