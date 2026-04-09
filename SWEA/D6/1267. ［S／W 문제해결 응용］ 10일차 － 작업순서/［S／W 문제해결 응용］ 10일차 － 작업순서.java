import java.io.*;
import java.util.*;

public class Solution {
    static List<Integer>[] adjList;
    static int[] indegree;

    public static void main(String[] args) throws IOException{
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int testCase = 1; testCase <= 10; testCase++) {
            sb.append("#").append(testCase).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            adjList = new List[V + 1];
            for (int i = 1; i <= V; i++) {
                adjList[i] = new ArrayList<>();
            }

            indegree = new int[V + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adjList[u].add(v);
                indegree[v]++;
            }

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 1; i <= V; i++) {
                if (indegree[i] == 0) deque.addLast(i);
            }

            int cnt = 0;
            while (!deque.isEmpty()) {
                int curr = deque.pollFirst();

                for (int next : adjList[curr]) {
                    if (--indegree[next] == 0) deque.addLast(next);
                }

                sb.append(curr).append(" ");
                cnt++;
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}