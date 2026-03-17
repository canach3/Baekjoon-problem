import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] nSumArr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nSumArr[i] = nSumArr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine().trim());
		
		int[] mSumArr = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			mSumArr[i] = mSumArr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		// A의 모든 부배열 담기
		int sizeA = 0;
		for (int i = 1; i <= N; i++) {
			sizeA += i;
		}
		
		int[] tmpA = new int[sizeA];
		int idx = 0;
		for (int i = 0; i <= N - 1; i++) {
			for (int j = i + 1; j <= N; j++) {
				tmpA[idx++] = nSumArr[j] - nSumArr[i];
			}
		}
		
		// B의 모든 부배열 담기
		int sizeB = 0;
		for (int i = 1; i <= M; i++) {
			sizeB += i;
		}
		
		int[] tmpB = new int[sizeB];
		idx = 0;
		for (int i = 0; i <= M - 1; i++) {
			for (int j = i + 1; j <= M; j++) {
				tmpB[idx++] = mSumArr[j] - mSumArr[i];
			}
		}
		
//		System.out.println("nSumArr : " + Arrays.toString(nSumArr));
//		System.out.println("mSumArr : " + Arrays.toString(mSumArr));
//		System.out.println("A : " + Arrays.toString(tmpA));
//		System.out.println("B : " + Arrays.toString(tmpB));
//		
		// 부배열 정렬
		Arrays.sort(tmpA);
		Arrays.sort(tmpB);
//		
//		System.out.println("정렬후");
//		System.out.println("A : " + Arrays.toString(tmpA));
//		System.out.println("B : " + Arrays.toString(tmpB));
		
		// 중복 제거(카운트 저장)
		List<int[]> A = new ArrayList<>();
		A.add(new int[] {tmpA[0], 1});
		
		idx = 0;
		for (int i = 1; i < tmpA.length; i++) {
			if (A.get(idx)[0] == tmpA[i]) {
				A.get(idx)[1]++;
			} else {
				A.add(new int[] {tmpA[i], 1});
				idx++;
			}
		}
		
		List<int[]> B = new ArrayList<>();
		B.add(new int[] {tmpB[0], 1});
		
		idx = 0;
		for (int i = 1; i < tmpB.length; i++) {
			if (B.get(idx)[0] == tmpB[i]) {
				B.get(idx)[1]++;
			} else {
				B.add(new int[] {tmpB[i], 1});
				idx++;
			}
		}
		
		
		
//		for (int i = 0; i < A.size(); i++) {
//			System.out.println(Arrays.toString(A.get(i)));
//		}
//		for (int i = 0; i < B.size(); i++) {
//			System.out.println(Arrays.toString(B.get(i)));
//		}
		
		long result = 0;
		
		for (int i = 0; i < A.size(); i++) {
			int left = 0;
			int right = B.size() - 1;
			
			int num1 = A.get(i)[0];
			int cnt = A.get(i)[1];
			
			while(left <= right) {
				int mid = left + (right - left) / 2;
				int num2 = B.get(mid)[0];
				
				if (num1 + num2 == T) {
					result += (long) cnt * B.get(mid)[1];
					break;
				}
				
				if (num1 + num2 < T) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		
		
		System.out.println(result);
		
			// A, B 두 배열 존재
			// T = A의 부배열의 합 + B의 부배열의 합

			// A의 모든 부배열의 개수 : n = 500500
			// B의 모든 부배열의 개수 : n = 500500
			
			// A 정렬 : n log n = 10,000,000
			// A 중복 제거 : n = 500500
			
			// B 정렬 : n log n = 10,000,000
			// B 중복 제거 : n = 500500
			
			// A와 B조합 찾기 이진탐색 : n log n = 10,000,000  	
	}
}