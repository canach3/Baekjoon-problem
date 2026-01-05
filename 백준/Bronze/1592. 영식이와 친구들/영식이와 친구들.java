import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		arr[1]++;
		
		int cnt = 0;
		int current = 1;
		
		while (arr[current] < M) {
			if (arr[current] % 2 == 1) {
				current = (current + N + L) % N;
			} else {
				current = (current + N - L) % N;
			}
			
			if (current == 0) {
				current = N;
			}
			
			arr[current]++;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}