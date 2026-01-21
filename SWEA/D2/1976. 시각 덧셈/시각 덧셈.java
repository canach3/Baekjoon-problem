import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int hour1 = Integer.parseInt(st.nextToken());
            int minute1 = Integer.parseInt(st.nextToken());
            int hour2 = Integer.parseInt(st.nextToken());
            int minute2 = Integer.parseInt(st.nextToken());

            int resultMin = (minute1 + minute2) % 60;
            int resultHour = (hour1 + hour2 + (minute1 + minute2) / 60) % 12;
            if (resultHour == 0) {
                resultHour = 12;
            }

            System.out.println("#" + testCase + " " + resultHour + " " + resultMin);
        }
    }
}