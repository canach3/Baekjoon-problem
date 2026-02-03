import java.io.*;
import java.util.*;

public class Solution {
    static int[][] arr;
    static int maxScore;
    static int N;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            maxScore = 0;
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                if (arr[i][1] <= L) {
                    DFS(i, 0, 0);
                }
            }

            System.out.println("#" + testCase + " " + maxScore);
        }
    }

    static void DFS(int current, int scoreSum, int calorieSum) {
        scoreSum += arr[current][0];
        calorieSum += arr[current][1];

        if (scoreSum > maxScore) {
            maxScore = scoreSum;
        }

        for (int i = current + 1; i < N; i++) {
            if (calorieSum + arr[i][1] <= L) {
                DFS(i, scoreSum, calorieSum);
            }
        }
    }
}