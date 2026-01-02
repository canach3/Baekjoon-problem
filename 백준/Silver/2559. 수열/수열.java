import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] sumArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (i == 0) {
				sumArr[i] = input;
			} else {
				sumArr[i] = sumArr[i - 1] + input;
			}
		}
		
		int max = sumArr[K - 1];
		for (int i = K; i < N; i++) {
			int sum = sumArr[i] - sumArr[i - K];
			
			if (sum > max) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}