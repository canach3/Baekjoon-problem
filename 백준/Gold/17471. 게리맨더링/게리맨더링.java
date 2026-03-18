import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] people;
    static List<Integer> A;
    static List<Integer> B;
    static int min;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        people = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                adjList.get(i).add(v);
            }
        }

        A = new ArrayList<>();
        B = new ArrayList<>();

        min = Integer.MAX_VALUE;
        select(1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    
    static void select(int idx) {
        // 종료조건
        if (idx == N + 1) {
            // 한 선거구가 빈 경우 제외
            if (A.isEmpty() || B.isEmpty()) return;

            // 인구수 차이가 최소인지 미리 확인
            int sumA = 0;
            int sumB = 0;

            for (Integer region : A) {
                sumA += people[region];
            }
            for (Integer region : B) {
                sumB += people[region];
            }

            int result = Math.abs(sumA - sumB);
            if (min <= result) return;

            // 가능한 방법인 지 확인
            int start = A.get(0);
            visited = new boolean[N + 1];
            DFS(start, true);
            for (int i = 0; i < A.size(); i++) {
                if (!visited[A.get(i)]) return;
            }

            start = B.get(0);
            visited = new boolean[N + 1];
            DFS(start, false);
            for (int i = 0; i < B.size(); i++) {
                if (!visited[B.get(i)]) return;
            }

            // 가능한 방법이면 min 업데이트
            min = result;
            return;
        }

        // A 선거구 선택
        A.add(idx);
        select(idx + 1);
        A.remove(A.size() - 1);

        // B 선거구 선택
        B.add(idx);
        select(idx + 1);
        B.remove(B.size() - 1);
    }

    static void DFS(int v, boolean isA) {
        visited[v] = true;

        for (Integer next : adjList.get(v)) {
            if (!visited[next]) {
                if (isA && A.contains(next)) {
                    DFS(next, isA);
                }
                else if (!isA && B.contains(next)){
                    DFS(next, isA);
                }
            }
        }
    }
}