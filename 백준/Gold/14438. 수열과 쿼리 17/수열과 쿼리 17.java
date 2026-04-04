import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        size = 1;
        while (size < N) {
            size *= 2;
        }
        size *= 2;

        tree = new int[size];
        Arrays.fill(tree, 1000000001);

        // 원본 배열 삽입
        int start = size / 2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[start + i] = Integer.parseInt(st.nextToken());
        }

        // 원본 배열 최솟값 저장
        for (int i = size / 2 - 1; i >= 1; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) update(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            else sb.append(getMin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.print(sb);
    }

    static void update(int idx, int value) {
        idx = size / 2 - 1 + idx;
        tree[idx] = value;

        for (int i = idx / 2; i >= 1; i /= 2) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    static int getMin(int left, int right) {
        left = size / 2 - 1 + left;
        right = size / 2 - 1 + right;

        int min = Integer.MAX_VALUE;
        while (left <= right) {
            if (left % 2 == 1) {
                min = Math.min(min, tree[left]);
                left++;
            }

            if (right % 2 == 0) {
                min = Math.min(min, tree[right]);
                right--;
            }

            left /= 2;
            right /= 2;
        }

        return min;
    }
}