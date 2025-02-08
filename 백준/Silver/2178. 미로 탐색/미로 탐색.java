import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = sc.next();

            for (int j = 0; j < input.length(); j++) {
                maze[i][j] = Integer.parseInt(input.substring(j, j + 1));
            }
        }

        BFS(0, 0);
        System.out.println(maze[N-1][M-1]);
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            visited[i][j] = true;

            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = current[0] + dx[k];
                int y = current[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < M) { // 배열을 넘어가면 안 됨
                    if (maze[x][y] != 0 && !visited[x][y]) { // 0이거나 이미 방문했거나
                        visited[x][y] = true;
                        maze[x][y] = maze[current[0]][current[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}