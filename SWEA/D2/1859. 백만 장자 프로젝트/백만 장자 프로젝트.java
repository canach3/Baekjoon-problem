import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];


            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[N - 1];
            long sum = 0;
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i] < max) {
                    sum += max - arr[i];
                } else {
                    max = arr[i];
                }
            }

            System.out.println("#" + testCase + " " + sum);
        }
    }
}