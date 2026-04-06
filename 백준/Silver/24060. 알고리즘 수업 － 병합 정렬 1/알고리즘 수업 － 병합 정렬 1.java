import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int cnt;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        result = 0;
        merge_sort(arr, 0, arr.length - 1);

        System.out.println(result == 0 ? -1 : result);
    }

    static void merge_sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(arr, left, mid);           // 전반부 정렬
            merge_sort(arr, mid + 1, right);  // 후반부 정렬
            merge(arr, left, mid, right);         // 병합
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        int[] tmp = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[t++] = arr[i++];
        }

        while (j <= right) {
            tmp[t++] = arr[j++];
        }

        i = left;
        t = 0;
        while (i <= right) {
            arr[i++] = tmp[t++];
            cnt++;

            if (cnt == K) result = arr[i - 1];
        }
    }
}