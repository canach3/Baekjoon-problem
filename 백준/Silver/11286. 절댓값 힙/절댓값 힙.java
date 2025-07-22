import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            long input = sc.nextLong();

            if (input == 0) {
                if (minHeap.isEmpty()) {
                    sb.append(0).append("\n");
                }else {
                    sb.append(minHeap.poll().num).append("\n");
                }
                continue;
            }

            minHeap.add(new Node(Math.abs(input), input));
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        long abs;
        long num;

        public Node(long abs, long num) {
            this.abs = abs;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            if (this.abs > o.abs) {
                return 1;
            }

            if (this.abs < o.abs) {
                return -1;
            }

            if (this.num > o.num) {
                return 1;
            }
            if (this.num < o.num) {
                return -1;
            }
            return 0;
        }
    }
}