import java.util.*;
import java.io.*;

public class Main {
    static Node[][] nodes;
    static boolean[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new Node[N + 2][M + 2];
        visited = new boolean[N + 2][M + 2];

        for (int i = 0; i <= N + 1; i++) {
            for (int j = 0; j <= M + 1; j++) {
                nodes[i][j] = new Node(0, j, i);
            }
        }

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            char[] chars = input.toCharArray();

            for (int j = 1; j <= chars.length; j++) {
                nodes[i][j].value = chars[j - 1] - '0';
            }
        }

        BFS(nodes[1][1]);
    }

    static void BFS(Node startNode) {
        visited[startNode.y][startNode.x] = true;
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(startNode);

        startNode.cnt = 1;

        while (!deque.isEmpty()) {
            Node currentNode = deque.removeFirst();

            if (currentNode.x == M && currentNode.y == N) {
                System.out.println(currentNode.cnt);
                return;
            }

            Node upNode = nodes[currentNode.y-1][currentNode.x]; // 상
            Node downNode = nodes[currentNode.y+1][currentNode.x]; // 하
            Node leftNode = nodes[currentNode.y][currentNode.x-1]; // 좌
            Node rightNode = nodes[currentNode.y][currentNode.x+1]; // 우

            if (upNode.value == 1 && !visited[upNode.y][upNode.x]) {
                visited[upNode.y][upNode.x] = true;
                upNode.cnt = currentNode.cnt + 1;
                deque.addLast(upNode);
            }

            if (downNode.value == 1 && !visited[downNode.y][downNode.x]) {
                visited[downNode.y][downNode.x] = true;
                downNode.cnt = currentNode.cnt + 1;
                deque.addLast(downNode);
            }

            if (leftNode.value == 1 && !visited[leftNode.y][leftNode.x]) {
                visited[leftNode.y][leftNode.x] = true;
                leftNode.cnt = currentNode.cnt + 1;
                deque.addLast(leftNode);
            }

            if (rightNode.value == 1 && !visited[rightNode.y][rightNode.x]) {
                visited[rightNode.y][rightNode.x] = true;
                rightNode.cnt = currentNode.cnt + 1;
                deque.addLast(rightNode);
            }
        }
    }

    static class Node {
        int value;
        int x;
        int y;
        int cnt;

        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
}