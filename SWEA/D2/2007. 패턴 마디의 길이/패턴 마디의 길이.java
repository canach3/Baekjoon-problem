import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();

            for (int i = 1; i <= 10; i++) {
                String word1 = input.substring(0, i);
                String word2 = input.substring(i, i + i);

                if (word1.equals(word2)) {
                    System.out.println("#" + testCase + " " + word1.length());
                    break;
                }
            }
        }
    }
}