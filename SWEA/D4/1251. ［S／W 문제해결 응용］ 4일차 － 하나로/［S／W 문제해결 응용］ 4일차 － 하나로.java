import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException{
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            N = Integer.parseInt(br.readLine().trim());

            int[] xArr = new int[N + 1];
            int[] yArr = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                xArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                yArr[i] = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine().trim());

            List<Edge> edgeList = new ArrayList<>();
            for (int i = 1; i <= N - 1; i++) {
                for (int j = i + 1; j <= N; j++) {
                    double cost = E * Math.abs(Math.pow(Math.abs(xArr[i] - xArr[j]), 2) + Math.pow(Math.abs(yArr[i] - yArr[j]), 2));
                    edgeList.add(new Edge(i, j, cost));
                }
            }

            Collections.sort(edgeList);

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            int cnt = 0;
            double sum = 0;
            for (Edge edge : edgeList) {
                if (cnt == N - 1) break;

                if (union(edge.v1, edge.v2)) {
                    sum += edge.cost;
                    cnt++;
                }
            }

            long result = Math.round(sum);

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static boolean union(int v1, int v2) {
        int v1Root = find(v1);
        int v2Root = find(v2);

        if (v1Root == v2Root) return false;

        parent[v2Root] = v1Root;
        return true;
    }

    static int find(int v) {
        if (parent[v] == v) return v;

        return parent[v] = find(parent[v]);
    }

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        double cost;

        Edge(int v1, int v2, double cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }
}