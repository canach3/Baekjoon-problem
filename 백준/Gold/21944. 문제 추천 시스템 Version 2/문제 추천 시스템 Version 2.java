import java.io.*;
import java.util.*;

public class Main {
    static TreeSet<Integer>[] LGtreeSet; // (난이도 + 문제분류)에 해당하는 문제들을 저장하는 treeSet
    static int[][] problems; // 모든 문제를 저장하는 2차원 배열

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = 0;
        int L = 0;
        int G = 0;
        int x = 0;

        // 자료구조 초기화
        LGtreeSet = new TreeSet[100101];
        for (int i = 1; i <= 100100; i++) {
            LGtreeSet[i] = new TreeSet<>();
        }

        problems = new int[100001][2];

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

            add(P, L, G);
        }

        int M = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "recommend":
                    G = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());

                    sb.append(recommend(G, x)).append("\n");
                    break;
                case "recommend2":
                    x = Integer.parseInt(st.nextToken());

                    sb.append(recommend2(x)).append("\n");
                    break;
                case "recommend3":
                    x = Integer.parseInt(st.nextToken());
                    L = Integer.parseInt(st.nextToken());

                    sb.append(recommend3(x, L)).append("\n");
                    break;
                case "add":
                    P = Integer.parseInt(st.nextToken());
                    L = Integer.parseInt(st.nextToken());
                    G = Integer.parseInt(st.nextToken());

                    add(P, L, G);
                    break;
                case "solved":
                    P = Integer.parseInt(st.nextToken());

                    solved(P);
                    break;
            }
        }

        System.out.print(sb);
    }

    static int recommend(int G, int x) {
        // G : 문제분류
        // x : 1 or -1

        /** 자료구조 : 2차원 배열 - [(난이도+문제분류)][TreeSet] **/

        int P = 0;

        // x = 1
        if (x == 1) {
            // 1. (난이도 100 ~ 1 순회 + 문제분류) 인덱스의 TreeSet 찾기 -> O(n) : 100
            for (int i = 100; i >= 1; i--) {
                TreeSet treeSet = LGtreeSet[i * 1000 + G];

                // 2. 이 비어있지 않다면 마지막 값 찾기 -> O(log N) : 7
                if (!treeSet.isEmpty()) {
                    P = (Integer) treeSet.last();
                    break;
                }
            }
        }

        // x = -1
        else {
            // 1. (난이도 1 ~ 100 순회 + 문제분류) 인덱스의 TreeSet 찾기 -> O(n) : 100
            for (int L = 1; L <= 100; L++) {
                TreeSet treeSet = LGtreeSet[L * 1000 + G];

                // 2. 이 비어있지 않다면 처음 값 찾기 -> O(log N) : 7
                if (!treeSet.isEmpty()) {
                    P = (Integer) treeSet.first();
                    break;
                }
            }
        }

        // 호출 수 : 10,000
        // 최종 : 7,000,000

        // TODO
        // x = 1 : 알고리즘 분류 G 중에 가장 어려운 문제번호 찾기, 여러개면 문제번호가 큰 것 우선
        // x = -1 : 알고리즘 분류 G 중에 가장 쉬운 문제번호 찾기, 여러개면 문제번호가 작은 것 우선

        // return : 조건을 만족하는 문제번호 반환
        return P;
    }

    static int recommend2(int x) {
        // x : 1 or -1

        int P = 0;

        // x = 1
        if (x == 1) {
            // 1. (난이도 100 ~ 1 순회 + 문제분류) 각 난이도별 마지막 값만 찾아서 비교하기(난이도의 수가 100개이므로 100개는 무조건 돌아야함)
            for (int L = 100; L >= 1; L--) {
                for (int G = 1; G <= 100; G++) {
                    TreeSet treeSet = LGtreeSet[L * 1000 + G];

                    // 2. 이 비어있지 않다면 마지막 값 찾기 -> O(log N) : 7
                    if (!treeSet.isEmpty()) {
                        P = Math.max(P, (Integer) treeSet.last());
                    }
                }
                if (P != 0) break;
            }
        }

        // x = -1
        else {
            P = Integer.MAX_VALUE;

            // 1. (난이도 1 ~ 100 순회 + 문제분류) 인덱스의 TreeSet 찾기 -> O(n) : 100
            for (int L = 1; L <= 100; L++) {
                for (int G = 1; G <= 100; G++) {
                    TreeSet treeSet = LGtreeSet[L * 1000 + G];

                    // 2. 이 비어있지 않다면 처음 값 찾기 -> O(log N) : 7
                    if (!treeSet.isEmpty()) {
                        P = Math.min(P, (Integer) treeSet.first());
                    }
                }
                if (P != Integer.MAX_VALUE) break;
            }
        }

        // 호출 수 : 10,000

        // TODO
        // x = 1 : 전체에서 가장 어려운 문제번호 찾기, 여러개면 문제번호가 큰 것 우선
        // x = -1 : 전체에서 가장 쉬운 문제번호 찾기, 여러개면 문제번호가 작은 것 우선

        // return : 조건을 만족하는 문제번호 반환
        return P;
    }

    static int recommend3(int x, int L) {
        // x : 1 or -1
        // L : 난이도

        int P = Integer.MAX_VALUE;

        // x = 1
        if (x == 1) {
            // 1. (난이도 L ~ 100 순회 + 문제분류) 각 난이도별 처음 값만 찾아서 비교하기(문제분류의 수가 100개이므로 100개는 무조건 돌아야함)
            for (L = L; L <= 100; L++) {
                for (int G = 1; G <= 100; G++) {
                    TreeSet treeSet = LGtreeSet[L * 1000 + G];

                    // 2. 이 비어있지 않다면 첫번째 값 찾기 -> O(log N) : 7
                    if (!treeSet.isEmpty()) {
                        P = Math.min(P, (Integer) treeSet.first());
                    }
                }
                if (P != Integer.MAX_VALUE) break;
            }
        }

        // x = -1
        else {
            P = 0;
            L--;
            for (;L >= 1; L--) {
                for (int G = 1; G <= 100; G++) {
                    TreeSet treeSet = LGtreeSet[L * 1000 + G];

                    // 2. 이 비어있지 않다면 첫번째 값 찾기 -> O(log N) : 7
                    if (!treeSet.isEmpty()) {
                        P = Math.max(P, (Integer) treeSet.last());
                    }
                }
                if (P != 0) break;
            }
        }

        // 호출 수 : 10,000

        // TODO
        // x = 1 : 전체에서 난이도 L보다 크거나 같은 문제 중 가장 쉬운 문제 번호 찾기, 여러개면 문제번호가 작은 것 우선
        // x = -1 : 전체에서 난이도 L보다  작은 문제 중 가장 어려운 문제 번호 찾기, 여러개면 문제번호가 큰 것 우선

        // return : 조건을 만족하는 문제번호 반환, 없으면 -1 반환
        return (P == 0) || (P == Integer.MAX_VALUE) ? -1 : P;
    }

    static void add(int P, int L, int G) {
        // P : 문제번호 <= 100,000
        // L : 난이도 <= 100
        // G : 알고리즘 분류 <= 100

        /** 자료구조 : 2차원 배열 - [(난이도+문제분류)][TreeSet] **/

        // 1. 전체 문제에 추가
        problems[P][0] = L;
        problems[P][1] = G;

        // 2. 해당 (난이도 + 문제분류)인덱스의 TreeSet 자료구조에 문제 삽입 -> O(log N) : 연산 수 : 17 미만
        LGtreeSet[L * 1000 + G].add(P);

        // 호출 수 : 10,000
        // 최종 : 170,000 미만

        // TODO : 난이도가 L이고 알고리즘 분류가 G인 문제 번호 P를 추가한다.
    }

    static void solved(int P) {
        // P : 문제번호

        /** 자료구조 :
         * 2차원 배열 - [(난이도+문제분류)][TreeSet]
         * 2차원 배열 - [문제번호][{난이도, 문제분류}]
         * **/

        // 1. 해당 문제의 분류와 난이도를 찾음  O(1)
        int L = problems[P][0];
        int G = problems[P][1];

        // 2. 해당 (난이도 + 분류) 에 해당하는 TreeSet 자료구조에서 해당 값 삭제 -> O(log N) : 연산 수 : 17 미만
        LGtreeSet[L * 1000 + G].remove(P);

        // 호출 수 : 10,000
        // 최종 : 170,000 미만

        // TODO : 해당 문제번호 제거
    }
}