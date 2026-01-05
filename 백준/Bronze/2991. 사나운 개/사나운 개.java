import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] time = new int[1000];
		for (int i = 1; i < 1000; i++) {
			if (i % (A + B) <= A && i % (A + B) >= 1) {
				time[i]++;
			}
			
			if (i % (C + D) <= C && i % (C + D) >= 1) {
				time[i]++;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < 3; j++) {
			int PMN = Integer.parseInt(st.nextToken());
			sb.append(time[PMN]).append("\n");
		}
		
		System.out.println(sb);
	}
}