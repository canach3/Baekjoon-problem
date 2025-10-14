import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }

                if (right == i) {
                    right--;
                    continue;
                }

                int result = numArr[left] + numArr[right];

                if (result == numArr[i]) {
                    cnt++;
                    break;
                }

                if (result > numArr[i]) {
                    right--;
                }

                if (result < numArr[i]) {
                    left++;
                }
            }
        }

        System.out.println(cnt);
    }
}