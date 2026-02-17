import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int N  = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int num = arr[i] * arr[j];
					String str = String.valueOf(num);
					
					boolean isOk = true;
					if (str.length() > 1) {
						for (int k = 0; k < str.length() - 1; k++) {
							if (str.charAt(k) > str.charAt(k + 1)) {
								isOk = false;
								break;
							}
						}
					}
					
					if (isOk) max = Math.max(max, num); 
				}
			}
			
			sb.append(max).append("\n");
		}
		
		System.out.print(sb);
	}
}