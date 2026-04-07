import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        cnt = 0;
        hanoi(N, 1, 2, 3);

        System.out.println(cnt);
        System.out.print(sb);
    }

    static void hanoi(int N, int from, int aux, int to) {
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            cnt++;
            return;
        }

        hanoi(N - 1, from, to, aux);
        sb.append(from).append(" ").append(to).append("\n");
        cnt++;
        hanoi(N - 1, aux, from, to);
    }
}