import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int lo = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> map = new TreeMap<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int key = Integer.parseInt(st.nextToken());
                if (map.get(key) == null) map.put(key, 1);
                else map.put(key, map.get(key) + 1);
            }

            int size = map.size();
            int[] sumArr = new int[size + 1];

            int idx = 1;
            for (Integer i : map.keySet()) {
                sumArr[idx++] = map.get(i);
            }

            for (int i = 2; i < sumArr.length; i++) {
                sumArr[i] = sumArr[i - 1] + sumArr[i];
            }

            int min = 1001;
            for (int i = 1; i <= size - 2; i++) {
                for (int j = i + 1; j <= size - 1; j++) {
                    int basket1 = sumArr[i];
                    int basket2 = sumArr[j] - sumArr[i];
                    int basket3 = sumArr[size] - sumArr[j];

                    if (basket1 >= lo && basket2 >= lo && basket3 >= lo) {
                        if (basket1 <= hi && basket2 <= hi && basket3 <= hi) {
                            int a = Math.abs(basket1 - basket2);
                            int b = Math.abs(basket1 - basket3);
                            int c = Math.abs(basket2 - basket3);

                            min = Math.min(min, Math.max(c, Math.max(a, b)));
                        }
                    }
                }
            }

            if (min == 1001) min = -1;

            sb.append(min).append("\n");
        }

        System.out.print(sb);
    }
}