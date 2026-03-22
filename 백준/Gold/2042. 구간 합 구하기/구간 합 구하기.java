import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1. 트리 초기화하기 (배열 생성)
        // 트리의 리프노드에 모든 데이터들이 들어가야함
        int size = 1; // 배열의 사이즈
        while (size < N) {
            size *= 2;
        }
        size *= 2;
        long[] tree = new long[size];

        // 2. 첫 원본데이터 담기
        // size / 2 : 트리의 첫 리프노드 위치(여기부터 원본 데이터가 들어감)
        for (int i = size / 2; i < (size / 2) + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
//        System.out.println(Arrays.toString(tree));

        // 3. 구간합 구하기
        for (int i = size - 1; i > 1; i--) {
            // 자신의 부모노드에 자신의 값을 더함
            tree[i / 2] += tree[i];
        }
//        System.out.println(Arrays.toString(tree));

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            // 데이터 수정
            if (command == 1) {
                int idx = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());

                idx = (size / 2 - 1) + idx; // 수정할 배열 인덱스를 트리기준으로 변경
                long old = tree[idx];

                // 자신의 값 변경으로 인해 영향을 미칠 조상노드들의 값도 수정(루트까지)
                for (int j = idx; j >= 1; j /= 2) {
                    tree[j] -= old;
                    tree[j] += value;
                }
//                System.out.println(Arrays.toString(tree));
            }

            // 구간합 구하기
            else {
                int left = (size / 2 - 1) + Integer.parseInt(st.nextToken());
                int right = (size / 2 - 1) + Integer.parseInt(st.nextToken());

                long sum = 0;
                while (left <= right) {
                    // left 에 위치한 노드가 오른쪽 자식일 때
                    if (left % 2 == 1) {
                        sum += tree[left];
                        left++;
                    }

                    // right 에 위치한 노드가 왼쪽 자식일 때
                    if (right % 2 == 0) {
                        sum += tree[right];
                        right--;
                    }

                    left /= 2;
                    right /= 2;
                }

                sb.append(sum).append("\n");
            }
        }

        System.out.print(sb);
    }
}