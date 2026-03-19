import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		PriorityQueue<Integer> leftPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		PriorityQueue<Integer> rightPq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine().trim());

			if (i % 2 == 0) {
				leftPq.add(num);
			} else {
				rightPq.add(num);
			}
			
			// left 중에서 가장 큰 값이 right 중에서 가장 작은 값보다 크다면 -> swap
			if (i >= 1 && leftPq.peek() > rightPq.peek()) {
				int tmp = leftPq.poll();
				leftPq.add(rightPq.poll());
				rightPq.add(tmp);
			}
			
			sb.append(leftPq.peek()).append("\n");
		}
		
		System.out.print(sb);
	}
}