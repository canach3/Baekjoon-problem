import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Node[] nodeArr = new Node[N];

        for (int i = 0; i < N; i++) {
            nodeArr[i] = new Node(i, Integer.parseInt(reader.readLine()));
        }
        
        Arrays.sort(nodeArr);
        
        int max = 0;

        for (int i = 0; i < N; i++) {
            int interval = nodeArr[i].index - i;
            if (interval > max) {
                max = interval;
            }
        }

        System.out.println(max + 1);
    }
    
    static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}