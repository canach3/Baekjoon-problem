import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String input = br.readLine();
			input = input + input.substring(0, (N / 4) - 1);

			Set<Long> set = new TreeSet<>();
			
			for (int i = 0; i < N; i++) {
				String tmp = input.substring(i, i + (N / 4));
				
				long sum = 0;
				
				for (int j = 0; j < N / 4; j++) {
					char c = tmp.charAt(j);
					long num = 0;
					
					switch (c) {
						case 'F':
							num = (long) (15 * Math.pow(16, N/4 - 1 - j));
							break;
						case 'E':
							num = (long) (14 * Math.pow(16, N/4 - 1 - j));
							break;
						case 'D':
							num = (long) (13 * Math.pow(16, N/4 - 1 - j));
							break;
						case 'C':
							num = (long) (12 * Math.pow(16, N/4 - 1 - j));
							break;
						case 'B':
							num = (long) (11 * Math.pow(16, N/4 - 1 - j));
							break;
						case 'A':
							num = (long) (10 * Math.pow(16, N/4 - 1 - j));
							break;
						default:
							num = (long) ((c - '0') * Math.pow(16, N/4 - 1 - j));
							break;
					}
					
					sum += num;
				}
				
				set.add(sum);
			}
			
			List<Long> list = new ArrayList<>(set);
			Collections.reverse(list);
			
			sb.append(list.get(K - 1)).append("\n");
		}
		
		System.out.print(sb);
	}
}