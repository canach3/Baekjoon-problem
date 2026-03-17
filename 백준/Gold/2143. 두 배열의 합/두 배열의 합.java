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
        
        // 1. 부배열 크기 공식으로 한 번에 계산
        int sizeA = N * (N + 1) / 2;
        int[] tmpA = new int[sizeA];
        int idx = 0;
        for (int i = 0; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                tmpA[idx++] = nSumArr[j] - nSumArr[i];
            }
        }
        
        int sizeB = M * (M + 1) / 2;
        int[] tmpB = new int[sizeB];
        idx = 0;
        for (int i = 0; i <= M - 1; i++) {
            for (int j = i + 1; j <= M; j++) {
                tmpB[idx++] = mSumArr[j] - mSumArr[i];
            }
        }
        
        // 부배열 정렬
        Arrays.sort(tmpA);
        Arrays.sort(tmpB);
        
        // 2. List 압축 및 이진 탐색 대신 투 포인터 적용
        long result = 0;
        int left = 0;
        int right = tmpB.length - 1;
        
        while (left < tmpA.length && right >= 0) {
            long sum = (long) tmpA[left] + tmpB[right]; // 오버플로우 방지
            
            if (sum == T) {
                int currentA = tmpA[left];
                long countA = 0;
                // A 배열에서 중복된 값 개수 한 번에 세기
                while (left < tmpA.length && tmpA[left] == currentA) {
                    countA++;
                    left++;
                }
                
                int currentB = tmpB[right];
                long countB = 0;
               
                while (right >= 0 && tmpB[right] == currentB) {
                    countB++;
                    right--;
                }
                
                result += countA * countB;
                
            } else if (sum < T) {
                left++; 
            } else {
                right--; 
            }
        }
        
        System.out.println(result);
    }
}