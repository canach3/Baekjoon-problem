import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[N];
        int[] hashMap = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            hashMap[n]++;
        }

        int target = Integer.parseInt(br.readLine().trim());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int key = target - arr[i];
            if (key < 0 || key > 1000000) continue;

            if (hashMap[key] == 1) {
                if (key != arr[i]) cnt++;
            }

            if (hashMap[key] > 1) {
                if (key != arr[i]) cnt += hashMap[key];
                else cnt += hashMap[key] - 1;
            }
        }

        System.out.println(cnt / 2);
    }
}