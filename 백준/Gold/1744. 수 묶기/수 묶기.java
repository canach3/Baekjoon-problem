import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();

            if (input == 0) {
                zeroCnt++;
                continue;
            }

            if (input == 1) {
                oneCnt++;
                continue;
            }

            maxHeap.add(input);
        }

        int sum = oneCnt;
        while (true) {
            int num1 = 0;
            int num2 = 0;

            if (!maxHeap.isEmpty() && maxHeap.peek() > 0) {
                num1 = maxHeap.poll();
            } else {
                break;
            }

            if (!maxHeap.isEmpty() && maxHeap.peek() > 0) {
                num2 = maxHeap.poll();
            } else {
                sum += num1;
                break;
            }

            sum += num1 * num2;
        }

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        minheap.addAll(maxHeap);

        while (true) {
            int num1 = 0;
            int num2 = 0;

            if (!minheap.isEmpty()) {
                num1 = minheap.poll();
            } else {
                break;
            }

            if (!minheap.isEmpty()) {
                num2 = minheap.poll();
            } else {
                if (zeroCnt > 0) {
                    break;
                } else {
                    sum += num1;
                    break;
                }
            }

            sum += num1 * num2;
        }

        System.out.println(sum);
    }
}