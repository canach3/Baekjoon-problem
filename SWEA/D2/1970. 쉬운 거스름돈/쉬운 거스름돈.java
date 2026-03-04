import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append("\n");
			
			int N = Integer.parseInt(br.readLine().trim());
			
			int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] arr = new int[8];
			
			for (int i = 0; i < 8; i++) {
				sb.append(N / coins[i]).append(" ");
				N %= coins[i];
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}