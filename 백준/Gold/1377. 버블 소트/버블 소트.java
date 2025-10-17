import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N];
        for(int i = 0; i < N; i++) {
            nodes[i] = new Node();
            nodes[i].firstIdx = i;
            nodes[i].value = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nodes);

        for(int i = 0; i < N; i++) {
            nodes[i].lastIdx = i;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int cnt = nodes[i].firstIdx - nodes[i].lastIdx + 1;

            if (cnt > max) {
                max = cnt;
            }
        }

        System.out.println(max);
    }

    static class Node implements Comparable<Node>{
        int value;
        int firstIdx;
        int lastIdx;

        @Override
        public int compareTo(Node o) {
            if (this.value > o.value) {
                return 1;
            }
            if (this.value < o.value) {
                return -1;
            }
            return 0;
        }
    }
}