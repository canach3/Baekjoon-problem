import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int M;
	static int K;
	static int A;
	static int B;
	static int[] a1;
	static int[] b1;
	
	static Client[] clients;
	static int[] arrA;
	static int[] arrB;
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 창구A 개수
			M = Integer.parseInt(st.nextToken()); // 창구B 개수	
			K = Integer.parseInt(st.nextToken()); // 고객 수
			
			A = Integer.parseInt(st.nextToken()); // 분실자의 창구A 번호
			B = Integer.parseInt(st.nextToken()); // 분실자의 창구B 번호
			
			a1 = new int[N + 1]; // 창구A 각 칸의 처리시간
			b1 = new int[M + 1]; // 창구B 각 칸의 처리시간
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				a1[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				b1[i] = Integer.parseInt(st.nextToken());
			}
			
			clients = new Client[K + 1];
			for (int i = 0; i < K + 1; i++) {
				clients[i] = new Client();
				clients[i].id = i;
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				clients[i].arriveA = Integer.parseInt(st.nextToken());
			}
			
			arrA = new int[N + 1]; // 창구A 각 칸의 이용가능시간
			arrB = new int[M + 1]; // 창구B 각 칸의 이용가능시간
			
			// 빈 창구가 여러곳일 경우 창구번호가 작은 곳으로
			for (int i = 1; i <= K; i++) {
				int min = Integer.MAX_VALUE;
				int idx = 0;
				for (int j = 1; j <= N; j++) {
					if (clients[i].arriveA >= arrA[j]) {
						idx = j;
						break;
					}
					
					else if (arrA[j] < min) {
						min = arrA[j];
						idx = j;
					}
				}
				
				clients[i].arriveB = Math.max(clients[i].arriveA, arrA[idx]) + a1[idx];
				clients[i].numA = idx;
				arrA[idx] = clients[i].arriveB;
			}
			
			Arrays.sort(clients);
			
			for (int i = 1; i <= K; i++) {
				int min = Integer.MAX_VALUE;
				int idx = 0;
				for (int j = 1; j <= M; j++) {
					if (clients[i].arriveB >= arrB[j]) {
						idx = j;
						break;
					}
					
					else if (arrB[j] < min) {
						min = arrB[j];
						idx = j;
					}
				}
				
				clients[i].numB = idx;
				arrB[idx] = Math.max(clients[i].arriveB, arrB[idx]) + b1[idx];
			}
			
			int result = 0;
			for (int i = 1; i <= K; i++) {
				if (clients[i].numA == A && clients[i].numB == B) result += clients[i].id;
			}
			
			sb.append(result == 0 ? -1 : result).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static class Client implements Comparable<Client>{
		int id;
		int arriveA;
		int arriveB;
		int numA;
		int numB;

		@Override
		public int compareTo(Client o) {
			if (Integer.compare(arriveB, o.arriveB) == 0) {
				return Integer.compare(numA, o.numA);
			}
			
			return Integer.compare(arriveB, o.arriveB);
		}
	}
}