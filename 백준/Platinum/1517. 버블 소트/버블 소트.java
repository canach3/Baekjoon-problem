import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static long result;
    public static void main(String[] args) throws IOException {
        result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        int[] temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(numArr, temp);
        System.out.println(result);
    }

    public static void mergeSort(int[] arr, int[] temp) {
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp, mid + 1, end);
        merge(arr, temp, start, mid, end);
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                result += mid + 1 - part1;
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }

        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = temp[part1 + i];
        }
    }
}