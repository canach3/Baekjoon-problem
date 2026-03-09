import java.io.*;
import java.util.*;

public class Solution {
    static int V;
    static int E;
    static Edge[] edgeList;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            parent = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                parent[i] = i;
            }

            edgeList = new Edge[E]; 
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edgeList[i] = new Edge(v1, v2, cost);
            }

            Arrays.sort(edgeList);

            long sum = 0;
            int cnt = 0;

            for (Edge edge : edgeList) {
                if (cnt == V - 1) break;

                int v1Root = findRoot(edge.v1);
                int v2Root = findRoot(edge.v2);

                if (v1Root != v2Root) {
                    parent[v2Root] = v1Root;
                    sum += edge.cost;
                    cnt++;
                }
            }

            sb.append("#").append(testCase).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }

    static class Edge implements Comparable<Edge> {
        int v1, v2, cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    static int findRoot(int v) {
        if (parent[v] == v) return v;
        return parent[v] = findRoot(parent[v]); 
    }
}