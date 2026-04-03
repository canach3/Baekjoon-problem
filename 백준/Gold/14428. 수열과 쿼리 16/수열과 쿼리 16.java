import java.io.*;
import java.util.*;

public class Main {
    static int[][] tree;
    static int size;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // tree 생성
        size = 1;
        while (size <= N) {
            size *= 2;
        }
        size *= 2;

        tree = new int[size][2];
        for (int i = 1; i < size; i++) {
            tree[i][0] = 1000000001;
        }

        // 원본 배열 삽입
        int idx = size / 2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[idx + i][0] = Integer.parseInt(st.nextToken());
            tree[idx + i][1] = i + 1;
        }

        // 초기 최솟값 구하기
        for (int i = size - 1; i >= 2; i--) {
            if (tree[i][0] <= tree[i / 2][0]) {
                tree[i / 2][0] = tree[i][0];
                tree[i / 2][1] = tree[i][1];
            }
        }

//        System.out.println();
//        for (int i = 0; i < size; i++) {
//            System.out.print(Arrays.toString(tree[i]));
//            System.out.print(" ");
//        }

        int M = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) update(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            else sb.append(getIdx(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.print(sb);
    }

    static void update(int idx, int value) {
        idx = size / 2 - 1 + idx;
        tree[idx][0] = value;

        while (idx >= 2) {
            // idx가 짝수인 경우
            if (idx % 2 == 0) {
                if (tree[idx][0] <= tree[idx + 1][0]) {
                    tree[idx / 2][0] = tree[idx][0];
                    tree[idx / 2][1] = tree[idx][1];
                } else {
                    tree[idx / 2][0] = tree[idx + 1][0];
                    tree[idx / 2][1] = tree[idx + 1][1];
                }
            }

            // idx가 홀수인 경우
            else {
                if (tree[idx - 1][0] <= tree[idx][0]) {
                    tree[idx / 2][0] = tree[idx - 1][0];
                    tree[idx / 2][1] = tree[idx - 1][1];
                } else {
                    tree[idx / 2][0] = tree[idx][0];
                    tree[idx / 2][1] = tree[idx][1];
                }
            }

            idx /= 2;
        }
    }

    static int getIdx(int left, int right) {
        left = size / 2 - 1 + left;
        right = size / 2 - 1 + right;

        int minIdx = 0;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            if (left % 2 == 1) {
                if (tree[left][0] == min) {
                    minIdx = Math.min(minIdx, tree[left][1]);
                }

                if (tree[left][0] < min) {
                    min = tree[left][0];
                    minIdx = tree[left][1];
                }

                left++;
            }

            if (right % 2 == 0) {
                if (tree[right][0] == min) {
                    minIdx = Math.min(minIdx, tree[right][1]);
                }

                if (tree[right][0] < min) {
                    min = tree[right][0];
                    minIdx = tree[right][1];
                }

                right--;
            }

            left /= 2;
            right /= 2;
        }

        return minIdx;
    }
}