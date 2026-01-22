import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arrA = new int[N];
            int[] arrB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            int big = Math.max(N, M);
            int small = Math.min(N, M);
            int max = 0;

            for (int i = 0; i <= big - small; i++) {
                int sum = 0;

                for (int j = 0; j < small; j++) {
                    if (N >= M) {
                        sum += arrA[i + j] * arrB[j];
                    } else {
                        sum += arrA[j] * arrB[i + j];
                    }
                }

                if (sum > max) {
                    max = sum;
                }
            }

            System.out.println("#" + testCase + " " + max);
        }
    }
}