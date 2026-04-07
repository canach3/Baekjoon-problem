import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int cnt;
    static int[] x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        cnt = 0;
        x = new int[N + 1];
        putQueen(1);

        System.out.println(cnt);
    }

    static void putQueen(int y) {
        if (y > N) {
            cnt++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            boolean possible = true;
            for (int j = 1; j < y; j++) {
                if (i == x[j] || Math.abs(i - x[j]) == (y - j)) {
                    possible = false;
                    break;
                }
            }

            if (!possible) continue;

            x[y] = i;
            putQueen(y + 1);
            x[y] = 0;
        }
    }
}