import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        Node[] nodeArr = new Node[N+1];
        for (int i = 1; i <= N; i++) {
            nodeArr[i] = new Node(i, sc.nextInt());
        }

        Deque<Node> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            while (!deque.isEmpty() && deque.peekLast().value < nodeArr[i].value) {
                deque.pollLast().NGE = nodeArr[i].value;
            }
            deque.addLast(nodeArr[i]);
        }

        while (!deque.isEmpty()) {
            deque.pollLast().NGE = -1;
        }

        for (int i = 1; i <= N; i++) {
            sb.append(nodeArr[i].NGE).append(" ");
        }

        System.out.println(sb);
    }
    static class Node{
        int index;
        int value;
        int NGE;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}