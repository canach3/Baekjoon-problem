import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 1; i < N; i++) {
            if (stack.isEmpty() || A[i-1] > A[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                    result[stack.pop()] = A[i];
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            str.append(result[i]).append(" ");
        }

        System.out.println(str);
    }
}