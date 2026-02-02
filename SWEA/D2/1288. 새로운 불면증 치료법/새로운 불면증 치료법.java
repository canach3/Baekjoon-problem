import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            boolean[] visited = new boolean[10];

            int N = Integer.parseInt(br.readLine());

            int cnt = 1;
            String result = "";
            boolean isCompleted = false;

            while(!isCompleted) {
                result = String.valueOf((N * cnt));

                for (int i = 0; i < result.length(); i++) {
                    int num = result.charAt(i) - '0';

                    if (!visited[num]) {
                        visited[num] = true;
                    }
                }

                for (int i = 0; i < 10; i++) {
                    if (!visited[i]) {
                        cnt++;
                        break;
                    }

                    if (i == 9){
                        isCompleted = true;
                    }
                }
            }

            System.out.println("#" + testCase + " " + result);
        }
    }
}