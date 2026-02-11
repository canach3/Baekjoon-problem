import java.io.*;
import java.util.*;

class Solution {
    static int sum;
    static int[][] tree;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            tree = new int[V + 1][3];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                tree[child][2] = parent;

                if (tree[parent][0] == 0) {
                    tree[parent][0] = child;
                } else {
                    tree[parent][1] = child;
                }
            }

            List<Integer> v1Parents = new ArrayList<>();
            List<Integer> v2Parents = new ArrayList<>();

            while (tree[v1][2] != 1) {
                v1Parents.add(tree[v1][2]);
                v1 = tree[v1][2];
            }

            while (tree[v2][2] != 1) {
                v2Parents.add(tree[v2][2]);
                v2 = tree[v2][2];
            }

            int commonParent = 1;
            for (Integer v1Parent : v1Parents) {
                if (v2Parents.contains(v1Parent)) {
                    commonParent = v1Parent;
                    break;
                }
            }

            sum = 0;
            DFS(commonParent);

            sb.append(commonParent).append(" ").append(sum).append(" ").append("\n");
        }

        System.out.print(sb);
    }

    static void DFS(int v) {
        if (v == 0) return;

        sum++;

        DFS(tree[v][0]);
        DFS(tree[v][1]);
    }
}