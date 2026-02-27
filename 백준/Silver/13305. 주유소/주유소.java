import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        long[][] cityArr = new long[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            cityArr[i][1] = Long.parseLong(st.nextToken()); // 이전도시 -> 현재도시 거리 담기
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cityArr[i][0] = Long.parseLong(st.nextToken()); // 주유비용 담기
        }

        long sum = 0;
        long km = 0;
        long minCost = cityArr[0][0];
        for (int i = 1; i < N; i++) {
            km += cityArr[i][1];

            if (i == N - 1) {            // 마지막 도시 처리
                sum += minCost * km;
                break;
            }

            long currentCost = cityArr[i][0];
            if (currentCost < minCost) { // 현재 도시가 주유비용이 더 싸면
                sum += minCost * km;
                minCost = currentCost;
                km = 0;
            }
        }

        System.out.println(sum);
    }
}