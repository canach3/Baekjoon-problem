import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        size = 1;
        while (size < N) {
            size *= 2;
        }
        size *= 2;

        tree = new long[size];

        // 원본 배열 삽입
        int start = size / 2;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[start + i] = Long.parseLong(st.nextToken());
        }

        // 원본 배열 구간합 저장
        for (int i = size / 2 - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(getSum(Math.min(x, y), Math.max(x, y))).append("\n");
            update(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.print(sb);
    }

    static void update(int idx, long value) {
        idx = size / 2 - 1 + idx;
        tree[idx] = value;

        for (int i = idx / 2; i >= 1; i /= 2) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long getSum(int left, int right) {
        left = size / 2 - 1 + left;
        right = size / 2 - 1 + right;

        long sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }

            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }

            left /= 2;
            right /= 2;
        }

        return sum;
    }
}