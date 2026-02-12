import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] bits = new int[31];

			for (int i = 0; M > 0; i++) {
				bits[30 - i] = M % 2;
				M /= 2;
			}
			
			boolean isOk = true;
			for (int i = 0; i < N; i++) {
				if (bits[30 - i] == 0) {
					isOk = false; 
					break;
				}
			}
			
			sb.append(isOk ? "ON" : "OFF").append("\n");
		}
		System.out.println(sb);
	}
}