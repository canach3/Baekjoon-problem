import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] numArr;
    static int[] operatorArr = new int[4];
    static int max;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            numArr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operatorArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            DFS(1, 0, 0, 0);
            int result = max - min;

            System.out.println("#" + testCase + " " + result);
        }
    }

    static void DFS(int cnt, int totalAmount, int numIdx, int operator) {
        switch (operator) {
            case 0:
                totalAmount += numArr[numIdx];
                break;
            case 1:
                totalAmount -= numArr[numIdx];
                break;
            case 2:
                totalAmount *= numArr[numIdx];
                break;
            case 3:
                totalAmount /= numArr[numIdx];
                break;
        }

        if (cnt == N) {
            if (totalAmount >= max) {
                max = totalAmount;
            }

            if (totalAmount <= min) {
                min = totalAmount;
            }

            return;
        }

        for (int i = 0; i < operatorArr.length; i++) {
            if (operatorArr[i] >= 1) {
                operatorArr[i]--;
                DFS(cnt + 1, totalAmount, numIdx + 1, i);
                operatorArr[i]++;
            }
        }
    }
}