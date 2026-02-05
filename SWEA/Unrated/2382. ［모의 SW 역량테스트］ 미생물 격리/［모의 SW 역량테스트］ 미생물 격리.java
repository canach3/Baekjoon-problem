import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Deque<Node>[][] map = new Deque[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = new ArrayDeque<>();
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                // 상:1 하:2 좌:3 우:4
                map[y][x].addFirst(new Node(q, d));
            }

            for (int time = 0; time < M; time++) {
                // 상 이동 : 상에서 하로 루프
                for (int i = 1; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!map[i][j].isEmpty() && map[i][j].peekLast().direction == 1) {
                            map[i - 1][j].addFirst(map[i][j].pollLast());
                        }
                    }
                }

                // 하 이동 : 하에서 상으로 루프
                for (int i = N - 2; i >= 0; i--) {
                    for (int j = 0; j < N; j++) {
                        if (!map[i][j].isEmpty() && map[i][j].peekLast().direction == 2) {
                            map[i + 1][j].addFirst(map[i][j].pollLast());
                        }
                    }
                }

                // 좌 이동 : 좌에서 우로 루프
                for (int i = 0; i < N; i++) {
                    for (int j = 1; j < N; j++) {
                        if (!map[i][j].isEmpty() && map[i][j].peekLast().direction == 3) {
                            map[i][j - 1].addFirst(map[i][j].pollLast());
                        }
                    }
                }

                // 우 이동 : 우에서 좌로 루프
                for (int i = 0; i < N; i++) {
                    for (int j = N - 2; j >= 0; j--) {
                        if (!map[i][j].isEmpty() && map[i][j].peekLast().direction == 4) {
                            map[i][j + 1].addFirst(map[i][j].pollLast());
                        }
                    }
                }

                // 전체 탐색 : 총 미생물 수, 방향 설정 (cesco 체크)
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        Deque<Node> queue = map[i][j];

                        // 가장자리인 경우
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                            // 방향 바꾸기
                            if (!queue.isEmpty()) {
                                Node node = queue.peekLast();

                                if (node.direction == 1 || node.direction == 2) {
                                    node.direction = 3 - node.direction;
                                }

                                if (node.direction == 3 || node.direction == 4) {
                                    node.direction = 7 - node.direction;
                                }

                                node.quantity /= 2;
                            }
                        } else {
                            // 겹치는 군집 합치기
                            int max = 0;
                            int max_d = 0;
                            int sum = 0;

                            while (!queue.isEmpty()) {
                                Node node = queue.pollLast();
                                sum += node.quantity;

                                if (node.quantity > max) {
                                    max = node.quantity;
                                    max_d = node.direction;
                                }
                            }

                            queue.addFirst(new Node(sum, max_d));
                        }
                    }
                }
            }

            int total = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Deque<Node> queue = map[i][j];
                    if (!queue.isEmpty()) {
                        total += queue.peekLast().quantity;
                    }
                }
            }

            System.out.println("#" + testCase + " " + total);
        }
    }

    static class Node {
        int quantity;
        int direction;

        Node(int quantity, int direction) {
            this.quantity = quantity;
            this.direction = direction;
        }
    }
}