import java.util.Scanner;
public class Main {
	static int N;
	static int [] tree;
	static int [] left;
	static int [] right;
	static int col = 1;
	static int [] minCol;
	static int [] maxCol;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tree = new int[N + 1];
		left = new int[N + 1];
		right = new int[N + 1];
		minCol = new int[N + 1]; 
		maxCol = new int[N + 1]; 
		
		for(int i = 1; i <= N; i++) {
			int p = sc.nextInt();
			int L = sc.nextInt();
			int R = sc.nextInt();
			left[p] = L;
			right[p] = R;
			
			if(L != -1) tree[L] = p;
		    if(R != -1) tree[R] = p;
		}
		
		
		for(int i = 1; i <= N; i++) {
			minCol[i] = Integer.MAX_VALUE;
			maxCol[i] = 0;
		}
		
		int root = 0;
		
		for(int i = 1; i <= N; i++) {
		    if(tree[i] == 0) {
		        root = i;
		        break;
		    }
		}
		
		dfs(root, 1);
		
		int maxWidth = 0;
		int answerLevel = 0;

		for (int i = 1; i <= N; i++) {
		    if (minCol[i] == Integer.MAX_VALUE) continue;

		    int width = maxCol[i] - minCol[i] + 1;

		    if (width > maxWidth) {
		        maxWidth = width;
		        answerLevel = i;
		    }
		}
		System.out.println(answerLevel + " " + maxWidth);
		
	}

	private static void dfs(int node, int level) {
		if(node == -1) return;
		
		dfs(left[node], level + 1);
		
		minCol[level] = Math.min(minCol[level], col);
		maxCol[level] = Math.max(maxCol[level], col);
		col++;
		
		dfs(right[node], level + 1);
	}
}
