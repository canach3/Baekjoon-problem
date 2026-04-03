import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int size;
    static final int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // tree 생성
        size = 1;
        while (size <= N) {
            size *= 2;
        }
        size *= 2;

        tree = new long[size];
        Arrays.fill(tree, 1);

        // 원본 배열 삽입
        int idx = size / 2;
        for (int i = 0; i < N; i++) {
            tree[idx + i] = Long.parseLong(br.readLine().trim());
        }

        // 초기 구간곱 구하기
        for (int i = size - 1; i >= 3; i -= 2) {
            tree[i / 2] = tree[i] * tree[i - 1] % MOD;
        }

        // 수정 및 특정 구간곱 구하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            if (command == 1) update(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
            else sb.append(search(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.print(sb);
    }

    static void update(int idx, long newNum) {
        idx = size / 2 - 1 + idx;
        tree[idx] = newNum;

        while (idx >= 2) {
            if (idx % 2 == 0) {
                tree[idx / 2] = tree[idx] * tree[idx + 1] % MOD;
            } else {
                tree[idx / 2] = tree[idx] * tree[idx - 1] % MOD;
            }

            idx /= 2;
        }
    }

    static long search(int left, int right) {
        left = size / 2 - 1 + left;
        right = size / 2 - 1 + right;

        long result = 1;
        while (left <= right) {
            if (left % 2 == 1) {
                result = result * tree[left] % MOD;
                left++;
            }

            if (right % 2 == 0) {
                result = result * tree[right] % MOD;
                right--;
            }

            left /= 2;
            right /= 2;
        }

        return result;
    }
}