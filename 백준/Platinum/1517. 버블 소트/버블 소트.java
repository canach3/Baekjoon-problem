import java.util.*;
import java.io.*;

public class Main {
    static int[] numArr;
    static int[] tmpArr;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        numArr = new int[N+1];
        tmpArr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        mergerSort(1, N);

        System.out.println(cnt);
    }

    static void mergerSort(int start, int end) {
        if (end - start < 1) {
            return;
        }

        int middle = start + (end - start) / 2;
        mergerSort(start, middle);
        mergerSort(middle + 1, end);

        for (int i = start; i <= end; i++) {
            tmpArr[i] = numArr[i];
        }

        int idx = start;
        int index1 = start;
        int index2 = middle + 1;

        while ((index1 <= middle) && (index2 <= end)) {
            if (tmpArr[index1] <= tmpArr[index2]) {
                numArr[idx] = tmpArr[index1];
                idx++;
                index1++;
            } else {
                numArr[idx] = tmpArr[index2];
                cnt += index2 - idx;
                idx++;
                index2++;
            }
        }

        while (index1 <= middle) {
            numArr[idx] = tmpArr[index1];
            idx++;
            index1++;
        }

        while (index2 <= end) {
            numArr[idx] = tmpArr[index2];
            idx++;
            index2++;
        }
    }
}