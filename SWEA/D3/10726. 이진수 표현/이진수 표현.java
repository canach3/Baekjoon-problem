import java.io.*;
import java.util.*;

public class Solution {
    static final int TARGET_MASK = (1 << 10) - 1;
    public static void main(String[] args) throws IOException{
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int target = (1 << N) - 1;

            sb.append((M & target) == target ? "ON" : "OFF").append("\n");
        }

        System.out.print(sb);
    }
}
