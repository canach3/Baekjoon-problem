import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int[] seq = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int maxPushNum = 0;

        // 처음 스택에 집어넣기
        for (int i = 1; i <= seq[0]; i++) {
            stack.push(i);
            maxPushNum = i;
            sb.append("+").append("\n");
        }

        stack.pollFirst();
        sb.append("-").append("\n");

        for (int i = 1; i < N; i++) {

            if (stack.isEmpty() || seq[i] > stack.peekFirst()) {
                for (int j = maxPushNum + 1; j <= seq[i]; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                maxPushNum = seq[i];
                stack.pollFirst();
                sb.append("-").append("\n");
                continue;
            }

            if (seq[i] < stack.peekFirst()) {
                System.out.println("NO");
                return;
            }

            if (seq[i] == stack.peekFirst()) {
                stack.pollFirst();
                sb.append("-").append("\n");
                continue;
            }
        }
        System.out.println(sb);
    }
}