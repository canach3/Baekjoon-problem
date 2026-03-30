import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int posCnt = 0;
        int[] positive = new int[N];

        int negCnt = 0;
        int[] negative = new int[N];

        boolean allPositive = true;
        boolean allNegative = true;
        boolean hasZero = false;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == 0) {
                hasZero = true;
                continue;
            }

            if (num > 0) {
                allNegative = false;
                positive[posCnt++] = num;
            }

            if (num < 0) {
                allPositive = false;
                negative[negCnt++] = num;
            }
        }

        if (allNegative) {
            if (hasZero) {
                System.out.println(negative[negCnt - 1] + " " + 0);
               return;
            }

            System.out.println(negative[negCnt - 2] + " " + negative[negCnt - 1]);
            return;
        }

        if (allPositive) {
            if (hasZero) {
                System.out.println(0 + " " + positive[0]);
                return;
            }

            System.out.println(positive[0] + " " + positive[1]);
            return;
        }

        int result1 = 0;
        int result2 = 0;
        int min = Integer.MAX_VALUE;

        if (hasZero) {
            if (Math.abs(negative[negCnt - 1]) <= positive[0]) {
                result1 = negative[negCnt - 1];
                min = Math.abs(result1);
            } else {
                result2 = positive[0];
                min = result2;
            }
        } else {
            if (negCnt >= 2) {
                result1 = negative[negCnt - 2];
                result2 = negative[negCnt - 1];
                min = Math.abs(result1 + result2);
            }

            if (posCnt >= 2) {
                if (positive[0] + positive[1] < min) {
                    result1 = positive[0];
                    result2 = positive[1];
                    min = result1 + result2;
                }
            }
        }

        for (int i = 0; i < negCnt; i++) {
            int n1 = negative[i];

            int left = 0;
            int right = posCnt - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                // 더하기가 양수이면 비교 후 저장하고 right = mid - 1
                int sum = n1 + positive[mid];

                if (sum >= 0) {
                    if (sum < min) {
                        result1 = n1;
                        result2 = positive[mid];
                        min = sum;
                    }

                    right = mid - 1;

                // 더하기가 음수이면 비교 후 저장하고 left = mid + 1
                } else {
                    if (Math.abs(sum) < min) {
                        result1 = n1;
                        result2 = positive[mid];
                        min = Math.abs(sum);
                    }

                    left = mid + 1;
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }
}