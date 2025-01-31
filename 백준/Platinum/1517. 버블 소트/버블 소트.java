import java.io.*;
import java.util.*;

public class Main {
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        int[] temp = new int[N]; // temp 배열을 미리 생성하여 재사용

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        mergeSort(numArr, temp, 0, N - 1);
        System.out.println(result);
    }

    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp, mid + 1, end);
        merge(arr, temp, start, mid, end);
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        System.arraycopy(arr, start, temp, start, end - start + 1);

        int part1 = start, part2 = mid + 1, index = start;

        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                arr[index++] = temp[part1++];
            } else {
                result += mid - part1 + 1;
                arr[index++] = temp[part2++];
            }
        }

        while (part1 <= mid) arr[index++] = temp[part1++];
        while (part2 <= end) arr[index++] = temp[part2++];
    }
}
