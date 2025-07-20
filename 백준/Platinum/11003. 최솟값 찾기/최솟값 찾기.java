import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        Node[] nodeArr = new Node[N+1];
        for (int i = 1; i <= N; i++) {
            nodeArr[i] = new Node();
            nodeArr[i].index = i;
            nodeArr[i].value = Integer.parseInt(st.nextToken());
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.push(nodeArr[1]);
        sb.append(nodeArr[1].value).append(" ");

        for (int i = 2; i <= N; i++) {
            if (i - L + 1 > deque.peekFirst().index) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && deque.peekLast().value > nodeArr[i].value) {
                deque.pollLast();
            }

            deque.addLast(nodeArr[i]);
            sb.append(deque.peekFirst().value).append(" ");
        }

        System.out.println(sb);
    }

    static class Node{
        int index;
        int value;
    }
}