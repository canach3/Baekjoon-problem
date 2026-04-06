import java.io.*;
import java.util.*;

public class Solution {
    static int[] parent;

    public static void main(String[] args) throws IOException{
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int command = Integer.parseInt(st.nextToken());
                if (command == 0) union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                else sb.append(isSameSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void union(int v1, int v2) {
        int v1Root = find(v1);
        int v2Root = find(v2);

        parent[v2Root] = v1Root;
    }

    static int find(int v) {
        if (parent[v] == v) return v;

        return parent[v] = find(parent[v]);
    }

    static int isSameSet(int v1, int v2) {
        int v1Root = find(v1);
        int v2Root = find(v2);

        if (v1Root == v2Root) return 1;
        else return 0;
    }
}