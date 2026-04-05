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

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) plus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            else sb.append(getSum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.print(sb);
    }

    static void plus(int idx, long amount) {
        idx = size / 2 - 1 + idx;
        tree[idx] += amount;

        for (int i = idx / 2; i >= 1; i /= 2) {
            tree[i] += amount;
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