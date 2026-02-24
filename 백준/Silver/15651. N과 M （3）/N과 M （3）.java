import java.util.*;
public class Main {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M];
		
		dfs(0);
		System.out.print(sb);
		
	}
	private static void dfs(int idx) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			arr[idx] = i;
			dfs(idx + 1);
		}
	}
}
