import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] operators;
    static int[] operands;
    static int max;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        operands = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            operands[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        DFS(0, operands[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int idx, int op1) {
        if (idx == N - 1) {
            max = Math.max(max, op1);
            min = Math.min(min, op1);
            return;
        }

        int op2 = operands[idx + 1];

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) continue;

            int result = 0;

            switch (i) {
                case 0:
                    result = op1 + op2;
                    break;
                case 1:
                    result = op1 - op2;
                    break;
                case 2:
                    result = op1 * op2;
                    break;
                case 3:
                    result = op1 / op2;
                    break;
            }

            operators[i]--;
            DFS(idx + 1, result);
            operators[i]++;
        }
    }
}