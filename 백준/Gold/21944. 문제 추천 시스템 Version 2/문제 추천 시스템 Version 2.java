import java.io.*;
import java.util.*;

public class Main {
    // 문제 정보를 담고 정렬 기준을 제공하는 클래스
    static class Problem implements Comparable<Problem> {
        int p, l, g;

        public Problem(int p, int l, int g) {
            this.p = p;
            this.l = l;
            this.g = g;
        }

        @Override
        public int compareTo(Problem o) {
            // 1순위: 난이도(L) 오름차순, 2순위: 문제 번호(P) 오름차순
            if (this.l == o.l) {
                return Integer.compare(this.p, o.p);
            }
            return Integer.compare(this.l, o.l);
        }
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());

        // 1. 전체 문제를 관리하는 TreeSet (recommend2, recommend3 용)
        TreeSet<Problem> globalSet = new TreeSet<>();
        
        // 2. 알고리즘 분류(G)별로 문제를 관리하는 TreeSet 배열 (recommend 용)
        // HashMap 대신 배열을 사용하여 탐색 속도 극대화 (G <= 100,000)
        TreeSet<Problem>[] groupSets = new TreeSet[100001];
        
        // 3. 문제 번호(P)로 문제 객체를 빠르게 찾기 위한 배열 (solved 용)
        // HashMap 대신 배열을 사용하여 $O(1)$ 탐색 최적화 (P <= 100,000)
        Problem[] problemMap = new Problem[100001];

        // 초기 문제 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            Problem prob = new Problem(p, l, g);
            globalSet.add(prob);
            
            if (groupSets[g] == null) groupSets[g] = new TreeSet<>();
            groupSets[g].add(prob);
            
            problemMap[p] = prob;
        }

        int M = Integer.parseInt(br.readLine().trim());
        
        // 명령어 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());

                Problem prob = new Problem(p, l, g);
                globalSet.add(prob);
                
                if (groupSets[g] == null) groupSets[g] = new TreeSet<>();
                groupSets[g].add(prob);
                
                problemMap[p] = prob;
                
            } else if (cmd.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                Problem prob = problemMap[p]; // $O(1)$ 로 삭제할 객체 찾기
                
                if (prob != null) {
                    globalSet.remove(prob); // $O(\log N)$
                    groupSets[prob.g].remove(prob); // $O(\log N)$
                    problemMap[p] = null;
                }
                
            } else if (cmd.equals("recommend")) {
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                
                if (x == 1) sb.append(groupSets[g].last().p).append("\n"); // 최댓값
                else sb.append(groupSets[g].first().p).append("\n"); // 최솟값
                
            } else if (cmd.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                
                if (x == 1) sb.append(globalSet.last().p).append("\n");
                else sb.append(globalSet.first().p).append("\n");
                
            } else if (cmd.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                
                if (x == 1) {
                    // 난이도 L보다 '크거나 같은' 문제 중 가장 쉬운 문제
                    // P를 0으로 설정하면 (L, 0)이 되므로 난이도가 L인 진짜 문제들(P >= 1)보다 무조건 작음
                    Problem res = globalSet.ceiling(new Problem(0, l, 0));
                    if (res == null) sb.append("-1\n");
                    else sb.append(res.p).append("\n");
                } else {
                    // 난이도 L보다 '작은' 문제 중 가장 어려운 문제
                    Problem res = globalSet.lower(new Problem(0, l, 0));
                    if (res == null) sb.append("-1\n");
                    else sb.append(res.p).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}