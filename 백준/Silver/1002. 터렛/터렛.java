import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(getIntersectionPointCount(x1, y1, r1, x2, y2, r2)).append("\n");
        }
        System.out.print(sb);
    }

    public static int getIntersectionPointCount(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distancePow = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);

        int rSumPow = (r1 + r2) * (r1 + r2);
        int rDiffPow = (r1 - r2) * (r1 - r2);

        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }

        if (distancePow > rSumPow || distancePow < rDiffPow) {
            return 0;
        }

        if (distancePow == rSumPow || distancePow == rDiffPow) {
            return 1;
        }

        return 2;
    }
}