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
			
			int[] checkTime = new int[N];
			long right = 0;
			
			for (int i = 0; i < N; i++) {
				checkTime[i] = Integer.parseInt(br.readLine().trim());
				right = Math.max(right, checkTime[i]);
			}
			
			right *= M;
			long left = 1;
			long result = 0;
			
			while (left <= right) {
				long mid = left + (right - left) / 2;
				
				long sum = 0;
				for (int i = 0; i < N; i++) {
					sum += mid / checkTime[i];
				}
				
				if (sum >= M) {
					result = mid;
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
	}
}