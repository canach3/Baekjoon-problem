import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine().trim());
            String input = br.readLine().trim();
            List<String> list = new LinkedList<>(Arrays.asList(input.split(" ")));

            int M = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < M; i++) {
                String insert = st.nextToken();
                int idx = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());

                for (int j = 0; j < cnt; j++) {
                    String num = st.nextToken();
                    list.add(idx + j, num);
                }
            }

            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}