import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			long N = Long.parseLong(br.readLine().trim());
			long cnt = 0;
			
			while (N != 2) {
				double tmp = Math.sqrt(N);
				
				if(Double.compare(tmp, (long) tmp) == 0) {
					N = (long) Math.sqrt(N);
					cnt++;
					continue;
				}
				
				cnt += (long) Math.pow((long) tmp + 1, 2) - N;
				N = (long) Math.pow((long) tmp + 1, 2);
				
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
}