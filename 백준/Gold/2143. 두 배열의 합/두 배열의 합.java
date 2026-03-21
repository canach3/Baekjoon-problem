import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        // a, b의 누적합 구하기 O(n) -> 2,000
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine().trim());
        int[] B = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B[i] = B[i - 1] + Integer.parseInt(st.nextToken());
        }

        // a, b 각각 모든 부배열의 합 구해서 HashMap 에 저장 -> 1,001,000
        Map<Integer, Integer> aMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int num = A[j] - A[i];
                if (aMap.get(num) == null) aMap.put(num, 1);
                else aMap.put(num, aMap.get(num) + 1);
            }
        }

        Map<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j <= M; j++) {
                int num = B[j] - B[i];
                if (bMap.get(num) == null) bMap.put(num, 1);
                else bMap.put(num, bMap.get(num) + 1);
            }
        }

        // T - a = b 가 존재하는 지 찾기 O(n) -> 500500
        long cnt = 0;
        for (Integer aKey : aMap.keySet()) {
            int aValue = aMap.get(aKey);
            int bKey = T - aKey;

            Integer bValue = bMap.get(bKey);
            if (bValue != null) cnt += (long) aValue * bValue;
        }

        System.out.println(cnt);
    }
}