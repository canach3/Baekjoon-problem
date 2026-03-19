import java.io.*;
import java.util.*;

public class Main {
    // 홈의 정보를 담을 클래스 (X좌표 및 방문 여부)
    static class Hole implements Comparable<Hole> {
        int x;
        boolean visited;

        public Hole(int x) {
            this.x = x;
            this.visited = false;
        }

        @Override
        public int compareTo(Hole o) {
            return Integer.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<Hole>[] graph = new ArrayList[200005];
        for (int i = 0; i <= 200000; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[y].add(new Hole(x));
        }

        for (int i = 0; i <= 200000; i++) {
            if (!graph[i].isEmpty()) {
                Collections.sort(graph[i]);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            int cnt = cur[2];

            if (cy == T) {
                System.out.println(cnt);
                return;
            }

            for (int ny = Math.max(0, cy - 2); ny <= Math.min(200000, cy + 2); ny++) {
                ArrayList<Hole> row = graph[ny];
                if (row.isEmpty()) continue;

                int left = 0;
                int right = row.size() - 1;
                int startIdx = row.size();

                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (row.get(mid).x >= cx - 2) {
                        startIdx = mid;
                        right = mid - 1; // 더 왼쪽으로 이동하며 최소 인덱스 찾기
                    } else {
                        left = mid + 1;
                    }
                }

                for (int i = startIdx; i < row.size(); i++) {
                    Hole target = row.get(i);
                    
                    if (target.x > cx + 2) break;

                    if (!target.visited) {
                        target.visited = true; // 방문 처리
                        queue.offer(new int[]{ny, target.x, cnt + 1});
                    }
                }
            }
        }

        System.out.println(-1);
    }
}