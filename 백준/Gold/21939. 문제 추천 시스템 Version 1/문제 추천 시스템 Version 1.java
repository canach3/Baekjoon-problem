import java.io.*;
import java.util.*;

public class Main {
    static Problem[] problems;
    static TreeSet<Problem> problemSet;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        problems = new Problem[100001];
        problemSet = new TreeSet<>();

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            add(P, L);
        }

        int M = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "recommend":
                    sb.append(recommend(Integer.parseInt(st.nextToken()))).append("\n");
                    break;
                case "add":
                    add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    break;
                case "solved":
                    solved(Integer.parseInt(st.nextToken()));
                    break;
            }
        }

        System.out.print(sb);
    }

    static int recommend(int x) {
        // x = 1 : 리스트에서 가장 어려운 문제 번호 출력
            // 여러개라면 문제 번호가 큰 것
        // x = -1 : 리스트에서 가장 쉬운 문제 번호 출력
            // 여러개라면 문제 번호가 작은 것

        if (x == 1) {
            return problemSet.last().P;
        } else {
            return problemSet.first().P;
        }
    }

    static void add(int P, int L) {
        // P : 문제번호
        // L : 난이도

        // 추천 문제 리스트에 난이도가 L인 문제번호 P 추가
        Problem problem = new Problem(P, L);
        problems[P] = problem;
        problemSet.add(problem);
    }

    static void solved(int P) {
        // P : 문제번호 (1 ~ 100,000)

        // 리스트에 문제번호 P 를 제거
        Problem problem = problems[P];
        problemSet.remove(problem);
    }

    static class Problem implements Comparable<Problem> {
        int P;
        int L;

        Problem(int P, int L) {
            this.P = P;
            this.L = L;
        }

        @Override
        public int compareTo(Problem o) {
            if (Integer.compare(this.L, o.L) == 0) {
                return Integer.compare(this.P, o.P);
            }

            return Integer.compare(this.L, o.L);
        }
    }
}