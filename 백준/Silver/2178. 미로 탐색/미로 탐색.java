import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] maze;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 2][M + 2];
        maze = new int[N + 2][M + 2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i + 1][j + 1] = input.charAt(j) - '0';
            }
        }

        BFS(1, 1);
    }

    static void BFS(int y, int x) {
        int cnt = 1;
        visited[y][x] = true;
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(new Node(y, x, 1));

        while (!deque.isEmpty()) {
            Node current = deque.removeLast();

            if (current.y == N && current.x == M) {
                System.out.println(current.cnt);
                return;
            }

            if (maze[current.y - 1][current.x] == 1 && !visited[current.y - 1][current.x]) {
                deque.addFirst(new Node(current.y - 1, current.x, current.cnt + 1));
                visited[current.y - 1][current.x] = true;
            }

            if (maze[current.y + 1][current.x] == 1 && !visited[current.y + 1][current.x]) {
                deque.addFirst(new Node(current.y + 1, current.x, current.cnt + 1));
                visited[current.y + 1][current.x] = true;
            }

            if (maze[current.y][current.x - 1] == 1 && !visited[current.y][current.x - 1]) {
                deque.addFirst(new Node(current.y, current.x - 1, current.cnt + 1));
                visited[current.y][current.x - 1] = true;
            }

            if (maze[current.y][current.x + 1] == 1 && !visited[current.y][current.x + 1]) {
                deque.addFirst(new Node(current.y, current.x + 1, current.cnt + 1));
                visited[current.y][current.x + 1] = true;
            }
        }

    }
    static class Node {
        int y;
        int x;
        int cnt;

        Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}