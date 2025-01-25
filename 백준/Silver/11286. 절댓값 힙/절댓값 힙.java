import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> {
            // 절댓값이 같은 경우 음수 우선
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }
            // 절댓값이 작은 숫자 우선
            return Math.abs(o1) - Math.abs(o2);
        });
        
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();

            if (input != 0) {
                minHeap.offer(input);
            } else {
                if (minHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(minHeap.poll());
                }
            }
        }
    }
}