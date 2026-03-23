import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 1. 사이즈 정하기
		int size = 1;
		while (size < N) {
			size *= 2;
		}
		size *= 2;
		
		// 2. 트리 생성 후, 초기화하기(minTree)
		int[] tree = new int[size];
		Arrays.fill(tree, 1, size, 4000001);
		
		
		// 3. 트리에 원본데이터 담기 (원본 데이터 값이 곧 인덱스)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int idx = Integer.parseInt(st.nextToken());
			tree[size / 2 - 1 + idx] = idx;
		}
		
		// 4. 트리의 전체 구간 최솟값 구하기
		for (int i = size - 1; i > 1; i--) {
			tree[i / 2] = Math.min(tree[i / 2], tree[i]);
		}
		
		// 5.매 입력마다 해당 구간의 최솟값 구하고 출력에 더하기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int left = size / 2 + Integer.parseInt(st.nextToken());
			int right = size / 2 - 1 + N;
			
			int min = 4000001;
			while (left <= right) {
				if (left % 2 == 1) {
					min = Math.min(min,  tree[left]);
					left++;
				}
				
				if (right % 2 == 0) {
					min = Math.min(min,  tree[right]);
					right--;
				}
				
				left /= 2;
				right /= 2;
			}
			
			sb.append(min).append("\n");
			
			// 사용된  원소 삭제하기(4,000,001로 바꾸기), tree 업데이트
			int idx = size / 2 - 1 + min;
			tree[idx] = 4000001;
			
			for (int j = idx / 2; j >= 1; j /= 2) {
				tree[j] = Math.min(tree[j * 2], tree[j * 2 + 1]);
			}
			
		}
		
		System.out.print(sb);
	}
}