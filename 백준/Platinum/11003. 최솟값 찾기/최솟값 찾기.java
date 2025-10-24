import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Node> nodeDeque = new ArrayDeque<>();

        nodeDeque.add(new Node(numArr[1], 1));
        sb.append(numArr[1]).append(" ");

        for (int i = 2; i <= N; i++) {
            if (nodeDeque.peekFirst().index < i - L + 1) {
                nodeDeque.removeFirst();
            }

            while(!nodeDeque.isEmpty() && nodeDeque.peekLast().value > numArr[i]) {
                nodeDeque.removeLast();
            }

            nodeDeque.addLast(new Node(numArr[i], i));
            sb.append(nodeDeque.peekFirst().value).append(" ");
        }

        System.out.println(sb);
    }

    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}