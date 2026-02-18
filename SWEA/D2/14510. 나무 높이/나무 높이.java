import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int N = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[N];
			
			int highest = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				highest = Math.max(highest, arr[i]);
			}
			
			int cnt1 = 0;
			int cnt2 = 0;
			
			for (int i = 0; i < N; i++) {
				cnt1 += (highest - arr[i]) % 2;
				cnt2 += (highest - arr[i]) / 2;
			}
			
			while (cnt1 < cnt2 - 1) {
				cnt1 += 2;
				cnt2 -= 1;
			}
			
			int result = 0;
			if (cnt1 <= cnt2) result = 2 * cnt2;
			else result = 2 * cnt1 - 1;
				
			sb.append(result).append("\n");
		}
		
		System.out.print(sb);
	}
}