import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }
        Arrays.sort(numArr);

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N-1;

            while (start < end) {
                if (start == i) {
                    start++;
                    continue;
                }

                if (end == i) {
                    end--;
                    continue;
                }

                if (numArr[start] + numArr[end] == numArr[i]) {
                    cnt++;
                    break;
                }

                if (numArr[start] + numArr[end] < numArr[i]) {
                    start++;
                }

                if (numArr[start] + numArr[end] > numArr[i]) {
                    end--;
                }
            }
        }
        System.out.println(cnt);
    }
}