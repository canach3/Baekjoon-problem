import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Node[] nodeArr = new Node[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nodeArr[i] = new Node(Integer.parseInt(st.nextToken()));
        }

        Deque<Node> nodeDeque = new ArrayDeque<>();

        for (int i = 0; i < N - 1; i++) {
            nodeDeque.addFirst(nodeArr[i]);

            while (!nodeDeque.isEmpty() && nodeDeque.peekFirst().value < nodeArr[i + 1].value) {
                nodeDeque.removeFirst().NGE = nodeArr[i + 1].value;
            }
        }

        while (!nodeDeque.isEmpty()) {
            nodeDeque.removeFirst().NGE = -1;
        }

        nodeArr[N-1].NGE = -1;

        for (int i = 0; i < N; i++) {
            sb.append(nodeArr[i].NGE).append(" ");
        }

        System.out.println(sb);
    }

    static class Node {
        int value;
        int NGE;

        Node(int value) {
            this.value = value;
        }
    }
}