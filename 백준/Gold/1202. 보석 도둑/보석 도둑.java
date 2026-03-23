import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 보석 개수
		int K = Integer.parseInt(st.nextToken()); // 가방 개수
		
		int[][] diamonds = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			diamonds[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		Arrays.sort(diamonds, (a, b) -> Integer.compare(a[0], b[0]));
		
		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine().trim());
		}
		
		Arrays.sort(bags);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b,  a));
		
		long sum = 0;
		int idx = 0;
		for (int i = 0; i < K; i++) {
			for (int j = idx; j < N; j++) {
				if (bags[i] < diamonds[j][0]) break;
				
				pq.add(diamonds[j][1]);
				idx++;
			}
			
			if (!pq.isEmpty()) {
				sum += pq.poll();
			}
		}
		
		System.out.println(sum);
	}
}