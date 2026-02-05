import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();

            int sum = 0;
            int cntOpen = 0;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '(') {
                    if (input.charAt(i + 1) == ')') {
                        sum += cntOpen;
                        i++;
                    } else {
                        cntOpen++;
                    }
                } else {
                    sum++;
                    cntOpen--;
                }
            }

            System.out.println("#" + testCase + " " + sum);
        }
    }
}