package 던전탈출;

import java.io.*;
import java.util.*;

class UserSolution {
    // init
    static int N;
    static int[][] map;
    static int maxStamina;

    // addGate
    static List<int[]> gateList;
    static List<List<int[]>> adjList;
    static List<Boolean> isActive;
    static boolean[][] visited;

    // BFS
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    void init(int mN, int mMaxStamina, int mMap[][]) {
        // 맵 입력받기
        N = mN;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.copyOf(mMap[i], N);
        }

        // 체력 입력받기
        maxStamina = mMaxStamina;

        // 인접리스트, 게이트리스트 객체 생성, 0번 인덱스 생성
        adjList = new ArrayList<>();
        adjList.add(new ArrayList<>());
        gateList = new ArrayList<>();
        gateList.add(new int[]{-1, -1});
        isActive = new ArrayList<>();
        isActive.add(false);
    }

    void addGate(int mGateID, int mRow, int mCol) {
        // 인접리스트, 게이트 리스트에 추가
        adjList.add(new ArrayList<>());
        gateList.add(new int[]{mRow, mCol});
        isActive.add(true);

        // 추가된 게이트로부터 기존 게이트까지의 거리 구하기
        visited = new boolean[N][N];
        BFS(mGateID);
    }

    static void BFS(int start) {
        int startY = gateList.get(start)[0];
        int startX = gateList.get(start)[1];

        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{startY, startX, 0});

        visited[startY][startX] = true;

        // 새로 추가된 게이트에서 기존 게이트들까지의 최단거리 구하기
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currY = current[0];
            int currX = current[1];
            int len = current[2];

            // 게이트 -> 게이트까지 거리가 체력보다 크다면 종료
            if (len > maxStamina) return;

            for (int i = 1; i < gateList.size(); i++) {
                // 현재 위치에 게이트가 존재하면
                if (gateList.get(i)[0] == currY && gateList.get(i)[1] == currX) {
                    // 인접리스트에 반영
                    adjList.get(start).add(new int[]{i, len});
                    adjList.get(i).add(new int[]{start, len});
                }
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];

                if (map[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;

                    deque.addLast(new int[] {nextY, nextX, len + 1});
                }
            }
        }
    }

    void removeGate(int mGateID) {
        // 삭제된 게이트 고려대상에서 제외
        isActive.set(mGateID, false);

//        // 인접리스트에서 해당 게이트 삭제하기
//        for (int i = 1; i < adjList.size(); i++) {
//            if (i == mGateID) continue;
//
//            List<int[]> node = adjList.get(i);
//            for (int j = 0; j < node.size(); j++) {
//                if (node.get(j)[0] == mGateID) {
//                    node.remove(j);
//                    break;
//                }
//            }
//        }
//
//        gateList.set(mGateID, new int[] {-1, -1});
    }

    int getMinTime(int mStartGateID, int mEndGateID) {
        // 최단 거리를 저장할 배열
        int[] dist = new int[gateList.size() + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 시작 게이트 dist = 0
        dist[mStartGateID] = 0;

        // 누적 시간(배열의 1번 인덱스)을 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{mStartGateID, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currNode = current[0];
            int currTime = current[1];

            // 종료 조건: 목적지에 도달하면 바로 반환
            if (currNode == mEndGateID) {
                return currTime;
            }

            // 4. 이미 더 짧은 경로로 해당 게이트를 방문한 적이 있다면 버리기
            if (currTime > dist[currNode]) {
                continue;
            }

            for (int[] node : adjList.get(currNode)) {
                int nextNode = node[0];
                int length = node[1];

                // 삭제된 게이트 제외
                if (!isActive.get(nextNode)) continue;

                // 체력으로 갈 수 있는 게이트인지 확인
                if (length <= maxStamina) {
                    int nextTime = currTime + length;

                    // 기존에 알려진 경로보다 더 짧은 시간으로 갈 수 있다면 갱신 후 큐에 삽입
                    if (nextTime < dist[nextNode]) {
                        dist[nextNode] = nextTime;
                        pq.offer(new int[]{nextNode, nextTime});
                    }
                }
            }
        }

        // 목적지에 도달하지 못했다면 -1 반환
        return -1;
    }
}
