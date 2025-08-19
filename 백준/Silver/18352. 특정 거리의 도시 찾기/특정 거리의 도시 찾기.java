import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int[] minCost;
    static ArrayList<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        minCost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            nodes[start].add(end);
        }

        BFS(X);

        boolean isEmpty = true;
        for (int i = 1; i <= N; i++) {
            if (minCost[i] == K) {
                sb.append(i).append("\n");
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println(-1);
        } else {
            System.out.print(sb);
        }
    }

    static void BFS(int startNode) {
        visited[startNode] = true;
        minCost[startNode] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(startNode);

        while (!deque.isEmpty()) {
            int currentNode = deque.removeLast();

            for (int i = 0; i < nodes[currentNode].size(); i++) {
                int nextNode = nodes[currentNode].get(i);

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    deque.addFirst(nextNode);
                    minCost[nextNode] = minCost[currentNode] + 1;
                }
            }
        }
    }


}