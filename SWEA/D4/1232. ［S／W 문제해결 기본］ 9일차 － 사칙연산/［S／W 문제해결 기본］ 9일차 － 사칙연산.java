import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static List<int[]> adjList;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine().trim());
			
			adjList = new ArrayList<>();
			
			for (int i = 0; i <= N; i++) {
				adjList.add(new int[3]);
			}
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int V = Integer.parseInt(st.nextToken());
				String input = st.nextToken();
				char op = input.charAt(0);
				
				if (op == '+' || op == '-' || op == '*' || op == '/') {
					adjList.get(V)[0] = op;
					adjList.get(V)[1] = Integer.parseInt(st.nextToken());
					adjList.get(V)[2] = Integer.parseInt(st.nextToken());
				} else {
					adjList.get(V)[0] = Integer.parseInt(input);
				}
			}
			
			double result = DFS(1);
			sb.append((int) result).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static double DFS(int num) {
		int[] node = adjList.get(num);
		
		if(node[1] == 0) {
			return node[0];
		} else {
			char operator = (char) node[0];
			
			switch(operator) {
				default:
				case '+':
					return DFS(node[1]) + DFS(node[2]);
				case '-':
					return DFS(node[1]) - DFS(node[2]);
				case '*':
					return DFS(node[1]) * DFS(node[2]);
				case '/':
					return DFS(node[1]) / DFS(node[2]);
			}
		}
	}
}	