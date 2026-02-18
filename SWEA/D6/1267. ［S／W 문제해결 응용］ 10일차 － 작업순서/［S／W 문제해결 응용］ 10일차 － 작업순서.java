import java.io.*;
import java.util.*;

public class Solution {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= 10; testCase++) {
            sb.append("#").append(testCase).append(" ");
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            adjList = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                adjList.add(new ArrayList<>());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adjList.get(start).add(end);
            }

            visited = new boolean[V + 1];
            stack = new Stack<>();

            // 모든 노드에 대해 방문하지 않았다면 DFS 수행
            for (int i = 1; i <= V; i++) {
                if (!visited[i]) DFS(i);
            }

            // 스택에서 꺼내면 위상 정렬 순서 (종료 시간의 역순)
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }

    static void DFS(int current) {
        visited[current] = true;

        for (int next : adjList.get(current)) {
            if (!visited[next]) {
                DFS(next);
            }
        }

        // 더 이상 갈 곳이 없을 때(작업 완료), 스택에 넣음
        // 가장 나중 작업이 스택 바닥에, 가장 먼저 해야 할 작업이 스택 꼭대기에 쌓임
        stack.push(current);
    }
}