import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();
            String result = new String(Base64.getDecoder().decode(input));

            System.out.println("#" + testCase + " " + result);
        }
    }
}