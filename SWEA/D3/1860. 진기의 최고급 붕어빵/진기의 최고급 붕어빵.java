import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] visit = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                visit[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(visit);

            boolean possible = true;
            for (int i = 0; i < N; i++) {
                if (visit[i] / M * K < i + 1) {
                    possible = false;
                    break;
                }
            }

            sb.append("#").append(testCase).append(" ").append(possible ? "Possible" : "Impossible").append("\n");
        }

        System.out.print(sb);
    }
}