import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static int M;
    static Map<Integer, Shark> sharks;

    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sharks = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            int key = C * y + x;
            sharks.put(key, new Shark(s, d, z));
        }

        int sum = 0;
        for (int mX = 0; mX < C; mX++) {
            // 동일한 열에서 가장 가까운 상어 잡기, 제거
            for (int i = 0; i < R; i++) {

                int idx = i * C + mX;
                Shark closeShark = sharks.get(idx);

                if (closeShark == null) continue;

                sum += closeShark.size;

                sharks.remove(idx);
                break;
            }

            // 상어 이동
            Map<Integer, Shark> tmpMap = new HashMap<>();
            for (int key : sharks.keySet()) {
                int sY = key / C;
                int sX = key % C;

                Shark shark = sharks.get(key);

                // 이동해야할 칸 계산
                int remain = shark.s;
                if (shark.d == 1 || shark.d == 2) remain %= (R - 1) * 2;
                else remain %= (C - 1) * 2;

                // 남은 칸을 이동
                // 상
                if (shark.d == 1) {
                    sY = sY + remain * dy[1];

                    // 벽에 부딪치는 경우
                    if (sY < 0) {
                        sY = Math.abs(sY);
                        shark.d = 2;
                    }

                    // 두 번 부딪치는 경우
                    if (sY > R - 1) {
                        sY = (R - 1) - (sY - (R - 1));
                        shark.d = 1;
                    }
                }

                // 하
                else if (shark.d == 2) {
                    sY = sY + remain * dy[2];

                    // 벽에 부딪치는 경우
                    if (sY > R - 1) {
                        sY = (R - 1) - (sY - (R - 1));
                        shark.d = 1;
                    }

                    // 두 번 부딪치는 경우
                    if (sY < 0) {
                        sY = Math.abs(sY);
                        shark.d = 2;
                    }
                }

                // 우
                else if (shark.d == 3) {
                    sX = sX + remain * dx[3];

                    // 벽에 부딪치는 경우
                    if (sX > C - 1) {
                        sX = (C - 1) - (sX - (C - 1));
                        shark.d = 4;
                    }

                    // 두 번 부딪치는 경우
                    if (sX < 0) {
                        sX = Math.abs(sX);
                        shark.d = 3;
                    }
                }

                // 좌
                else if (shark.d == 4) {
                    sX = sX + remain * dx[4];

                    // 벽에 부딪치는 경우
                    if (sX < 0) {
                        sX = Math.abs(sX);
                        shark.d = 3;
                    }

                    // 두 번 부딪치는 경우
                    if (sX > C - 1) {
                        sX = (C - 1) - (sX - (C - 1));
                        shark.d = 4;
                    }
                }

                // 최종 위치 인덱스화
                int idx = C * sY + sX;

                // 해당 위치에 다른 상어가 존재하는 경우
                Shark anotherShark = tmpMap.get(idx);
                if (anotherShark != null) {
                    if (shark.size > anotherShark.size) {
                        tmpMap.put(idx, shark);
                    }
                } else {
                    tmpMap.put(idx, shark);
                }
            }

            // 맵 교체
            sharks = new HashMap<>(tmpMap);
        }

        System.out.println(sum);
    }

    static class Shark {
        int s;
        int d;
        int size;

        Shark(int s, int d, int size) {
            this.s = s;
            this.d = d;
            this.size = size;
        }
    }
}