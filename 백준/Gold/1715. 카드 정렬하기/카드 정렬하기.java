import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            minheap.add(sc.nextInt());
        }

        int result = 0;

        while (minheap.size() >= 2) {
            int cards1 = minheap.poll();
            int cards2 = minheap.poll();
            int sum = cards1 + cards2;
            result += sum;
            minheap.add(sum);
        }

        System.out.println(result);
    }
}