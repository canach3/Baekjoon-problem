import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        long[] arr = new long[N];
        TreeMap<Long, Long> map = new TreeMap<>();

        long sum = 0;
        long maxCnt = 0;
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];

            if (map.get(arr[i]) == null) {
                map.putIfAbsent(arr[i], 1L);
            } else {
                map.replace(arr[i], map.get(arr[i]) + 1);
            }

            maxCnt = Math.max(maxCnt, map.get(arr[i]));
        }

        Arrays.sort(arr);

        long mode = 0;
        int cnt = 0;
        for (long key : map.keySet()) {
            long value = map.get(key);
            if (value == maxCnt) {
                mode = key;
                cnt++;
            }

            if (cnt == 2) break;
        }

        System.out.println((int) Math.round((double) sum / N));
        System.out.println(arr[N / 2]);
        System.out.println(mode);
        System.out.println(max - min);
    }
}