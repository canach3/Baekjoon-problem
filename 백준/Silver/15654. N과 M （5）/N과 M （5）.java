import java.util.*;
public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] ans;
	static boolean [] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		ans = new int[M];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		dfs(0);
		
		
	}
	private static void dfs(int idx) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				
				ans[idx] = arr[i];
				dfs(idx + 1);
				
				visited[i] = false;
			}
		}
		
	}
}
