import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();

            String yearS = input.substring(0, 4);
            String monthS = input.substring(4, 6);
            String dayS = input.substring(6, 8);

            int month = Integer.parseInt(monthS);
            if (month < 1 || month > 12) {
                System.out.println("#" + testCase + " " + -1);
                continue;
            }

            int day = Integer.parseInt(dayS);

            if (day < 1) {
                System.out.println("#" + testCase + " " + -1);
                continue;
            }

            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day > 31) {
                    System.out.println("#" + testCase + " " + -1);
                    continue;
                }
            } else if (month == 2) {
                if (day > 28) {
                    System.out.println("#" + testCase + " " + -1);
                    continue;
                }
            } else {
                if (day > 30) {
                    System.out.println("#" + testCase + " " + -1);
                    continue;
                }
            }

            System.out.println("#" + testCase + " " + yearS + "/" + monthS + "/" + dayS);
        }
    }
}