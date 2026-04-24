import java.io.*;
import java.util.*;

public class Main {
    static int size;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 트리 사이즈 설정
        size = 1;
        while (size < N) {
            size *= 2;
        }
        size *= 2;

        // 트리 생성
        tree = new long[size];

        // 원본배열 삽입
        int idx = size / 2;
        for (int i = 0; i < N; i++) {
            tree[idx++] = Long.parseLong(br.readLine());
        }

        // 초기 구간합 구하기
        for (int i = size - 1; i >= 2; i -= 2) {
            tree[i / 2] = tree[i] + tree[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                update(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
            } else {
                sb.append(search(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
            }
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

    static long search(int left, int right) {
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