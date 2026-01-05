import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[L + 1];
		
		int expectMax = 0;
		int expectMaxIdx = 0;
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if (K - P > expectMax) {
				expectMax = K - P;
				expectMaxIdx = i;
			}
			
			for (int j = P; j <= K; j++) {
				if (arr[j] == 0) {
					arr[j] = i;
				}
			}
		}
		
		int realMax = 0;
		int realMaxIdx = 1;
		
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j < L; j++) {
				if (arr[j] == i) {
					cnt++;
				}
			}
			
			if (cnt > realMax) {
				realMax = cnt;
				realMaxIdx = i;
			}
		}
		
		System.out.println(expectMaxIdx);
		System.out.println(realMaxIdx);
	}
}