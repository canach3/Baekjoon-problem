import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            int max = 0;
            for (int i = 0; i < N - 2; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
                int calculate = Math.abs(arr[i] - arr[i + 1]) + Math.abs(arr[i + 1] - arr[i + 2]) - Math.abs(arr[i] - arr[i + 2]);

                if (calculate > max) {
                    max = calculate;
                }
            }

            sum += Math.abs(arr[N - 2] - arr[N - 1]);

            System.out.println(sum - max);
        }
    }
}