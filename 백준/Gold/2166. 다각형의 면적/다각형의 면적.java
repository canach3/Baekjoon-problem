import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[][] xy = new long[N + 1][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy[i][0] = Long.parseLong(st.nextToken());
            xy[i][1] = Long.parseLong(st.nextToken());
        }

        xy[N][0] = xy[0][0];
        xy[N][1] = xy[0][1];

        double sumA = 0;
        for (int i = 0; i < N; i++) {
            sumA += xy[i][0] * xy[i + 1][1];
        }

        double sumB = 0;
        for (int i = 0; i < N; i++) {
            sumB += xy[i][1] * xy[i + 1][0];
        }

        String result = String.format("%.1f", Math.abs(sumA - sumB) / 2);

        System.out.println(result);
    }
}