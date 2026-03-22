import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // tree size 구하기
        int size = 1;
        while (size < N) {
            size *= 2;
        }
        size *= 2;

        // segment tree 생성, 초기화
        int[] minTree = new int[size];
        for (int i = 1; i < size; i++) {
            minTree[i] = 1000000001;
        }

        int[] maxTree = new int[size];

        // tree에 원본 데이터 삽입
        for (int i = size / 2; i < size / 2 + N; i++) {
            minTree[i] = maxTree[i] = Integer.parseInt(br.readLine());
        }

        // 각 트리의 모든 구간의 최솟값, 최댓값 구하기
        for (int i = size - 1; i > 1; i--) {
            minTree[i / 2] = Math.min(minTree[i / 2], minTree[i]);
            maxTree[i / 2] = Math.max(maxTree[i / 2], maxTree[i]);
        }

        // 각 트리의 입력받은 구간의 최솟값, 최댓값 구하기        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = (size / 2 - 1) + Integer.parseInt(st.nextToken());
            int right = (size / 2 - 1) + Integer.parseInt(st.nextToken());

            int min = 1000000001;
            int max = 0;

            while (left <= right) {
                if (left % 2 == 1) {
                    min = Math.min(min, minTree[left]);
                    max = Math.max(max, maxTree[left]);
                    left++;
                }

                if (right % 2 == 0) {
                    min = Math.min(min, minTree[right]);
                    max = Math.max(max, maxTree[right]);
                    right--;
                }

                left /= 2;
                right /= 2;
            }

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}