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

        // tree에 데이터 집어넣기
        int[] tree = new int[size];
        for (int i = 1; i < size; i++) {
            tree[i] = 1000000001;
        }

        for (int i = size / 2; i < (size / 2) + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        // 구간별 최솟값 구하기
        for (int i = size - 1; i > 1; i--) {
            tree[i / 2] = Math.min(tree[i / 2], tree[i]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = (size / 2 - 1) + Integer.parseInt(st.nextToken());
            int right = (size / 2 - 1) + Integer.parseInt(st.nextToken());

            int min = Integer.MAX_VALUE;
            while (left <= right) {
                // left 가 오른쪽 자식인 경우
                if (left % 2 == 1) {
                    min = Math.min(min, tree[left]);
                    left++;
                }

                // right 가 왼쪽 자식인 경우
                if (right % 2 == 0) {
                    min = Math.min(min, tree[right]);
                    right--;
                }

                left /= 2;
                right /= 2;
            }

            sb.append(min).append("\n");
        }

        System.out.print(sb);
    }
}