import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();

            int max = 0;
            int distance = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'L') {
                    distance--;
                }
                if (input.charAt(i) == 'R') {
                    distance++;
                }
                if (input.charAt(i) == '?') {
                    distance--;
                }

                if (Math.abs(distance) > max) {
                    max = Math.abs(distance);
                }
            }

            distance = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'L') {
                    distance--;
                }
                if (input.charAt(i) == 'R') {
                    distance++;
                }
                if (input.charAt(i) == '?') {
                    distance++;
                }

                if (Math.abs(distance) > max) {
                    max = Math.abs(distance);
                }
            }

            System.out.println(max);
        }
    }
}