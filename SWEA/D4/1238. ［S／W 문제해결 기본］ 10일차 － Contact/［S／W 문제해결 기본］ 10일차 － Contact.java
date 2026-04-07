import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            sb.append("#").append(testCase).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()) / 2;
            int start = Integer.parseInt(st.nextToken());

            List<Integer>[] adjList = new List[101];
            for (int i = 1; i <= 100; i++) {
                adjList[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }

            int[] time = new int[101];
            boolean[] visited = new boolean[101];
            visited[start] = true;

            Deque<Integer> deque = new ArrayDeque<>();
            deque.addLast(start);

            int max = 0;
            int maxIdx = 0;

            while (!deque.isEmpty()) {
                int curr = deque.pollFirst();

                if (time[curr] >= max) {
                    if (time[curr] == max){
                        maxIdx = Math.max(maxIdx, curr);
                    } else{
                        max = time[curr];
                        maxIdx = curr;
                    }
                }

                for (int next : adjList[curr]) {
                    if (visited[next]) continue;

                    visited[next] = true;
                    time[next] = time[curr] + 1;
                    deque.addLast(next);
                }
            }

            sb.append(maxIdx).append("\n");
        }

        System.out.print(sb);
    }
}