import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int[] sumArr = new int[13];
            for (int i = 1; i <= 12; i++) {
                sumArr[i] = sumArr[i - 1] + months[i];
            }

            int month1 = Integer.parseInt(st.nextToken());
            int day1 = Integer.parseInt(st.nextToken());
            int month2 = Integer.parseInt(st.nextToken());
            int day2 = Integer.parseInt(st.nextToken());

            int result = sumArr[month2 - 1] + day2 - sumArr[month1 - 1] - day1 + 1;

            System.out.println("#" + testCase + " " + result);
        }
    }
}