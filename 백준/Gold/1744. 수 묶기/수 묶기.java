import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minusMaxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> plusMaxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input <= 0) {
                minusMaxHeap.add(Math.abs(input));
            } else {
                plusMaxHeap.add(input);
            }
        }

        int sum = 0;

        while (!minusMaxHeap.isEmpty()) {
            if (minusMaxHeap.size() == 1) {
                sum -= minusMaxHeap.remove();
                break;
            }

            int n1 = minusMaxHeap.remove();
            int n2 = minusMaxHeap.remove();
            sum += n1 * n2;
        }

        while (!plusMaxHeap.isEmpty()) {
            if (plusMaxHeap.size() == 1) {
                sum += plusMaxHeap.remove();
                break;
            }

            int n1 = plusMaxHeap.remove();
            int n2 = plusMaxHeap.remove();

            if (n1 == 1 || n2 == 1) {
                sum += n1 + n2;
            } else {
                sum += n1 * n2;
            }
        }

        System.out.println(sum);
    }
}