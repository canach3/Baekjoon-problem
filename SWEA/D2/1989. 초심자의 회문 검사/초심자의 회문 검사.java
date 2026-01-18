import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();

            boolean isPalindrome = true;
            for (int i = 0, j = input.length() - 1; i < input.length() / 2; i++, j--) {
                if (input.charAt(i) != input.charAt(j)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                System.out.println("#" + testCase + " " + 1);
            } else {
                System.out.println("#" + testCase + " " + 0);
            }
        }
    }
}