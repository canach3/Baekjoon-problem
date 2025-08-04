import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numArr1 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] numArr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            numArr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr1);

        for (int findNum : numArr2) {
            int low = 0;
            int high = numArr1.length - 1;
            int middle;
            boolean find = false;

            while (low <= high) {
                middle = low + (high - low) / 2;

                if (findNum == numArr1[middle]) {
                    sb.append(1).append("\n");
                    find = true;
                    break;
                }

                if (findNum < numArr1[middle]) {
                    high = middle - 1;
                }

                if (findNum > numArr1[middle]) {
                    low = middle + 1;
                }
            }

            if (!find) {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}