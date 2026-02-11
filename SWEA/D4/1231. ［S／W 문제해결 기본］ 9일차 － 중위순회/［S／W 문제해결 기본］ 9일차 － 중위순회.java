import java.io.*;
import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static char[] tree;
    static int size;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine().trim());
            for (size = 2; size <= N + 1; size *= 2);
            tree = new char[size + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                tree[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
            }

            inOrder(1);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void inOrder(int v) {
        if (v > size || tree[v] == '\u0000') return;

        inOrder(v * 2);
        sb.append(tree[v]);
        inOrder(v * 2 + 1);
    }
}