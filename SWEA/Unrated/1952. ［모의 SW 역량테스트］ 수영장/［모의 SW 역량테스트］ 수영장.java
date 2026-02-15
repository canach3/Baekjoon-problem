import java.io.*;
import java.util.*;
 
public class Solution {
	static int[] tickets;
	static int[] months;
	static int min;

	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			tickets = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 4; i++) {
				tickets[i] = Integer.parseInt(st.nextToken());
			} 
			
			months = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				months[i] = Integer.parseInt(st.nextToken());
			}
			
			min = tickets[3];
			
			DFS(1, 0);
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int month, int totalCost) {
		if (month >= 13) {
			min = Math.min(min, totalCost);
			return;
		}
		
		DFS(month + 1, totalCost + months[month] * tickets[0]); // 1일권 사용
		DFS(month + 1, totalCost + tickets[1]); // 1달권 사용
		DFS(month + 3, totalCost + tickets[2]); // 3달권 사용
	}
}