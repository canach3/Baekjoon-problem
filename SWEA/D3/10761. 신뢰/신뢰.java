import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            Deque<Integer> orange = new ArrayDeque<>();
            Deque<Integer> blue = new ArrayDeque<>();
            Deque<Integer> turns = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                char robot = st.nextToken().charAt(0);
                if (robot == 'O') {
                    orange.addFirst(Integer.parseInt(st.nextToken()));
                    turns.addFirst(0);
                } else {
                    blue.addFirst(Integer.parseInt(st.nextToken()));
                    turns.addFirst(1);
                }
            }

            int time = 0;
            int oIdx = 1;
            int bIdx = 1;

            while (!turns.isEmpty()) {
                int turn = turns.peekLast();
                time++;

                if (turn == 0) { // 오렌지 턴
                    if (oIdx == orange.peekLast()) {
                        orange.pollLast();
                        turns.pollLast();
                    } else {
                        oIdx += orange.peekLast() > oIdx ? 1 : -1;
                    }

                    if (!blue.isEmpty() && bIdx != blue.peekLast()) bIdx += blue.peekLast() > bIdx ? 1 : -1;
                }

                if (turn == 1) { // 블루 턴
                    if (bIdx == blue.peekLast()) {
                        blue.pollLast();
                        turns.pollLast();
                    } else {
                        bIdx += blue.peekLast() > bIdx ? 1 : -1;
                    }

                    if (!orange.isEmpty() && oIdx != orange.peekLast()) oIdx += orange.peekLast() > oIdx ? 1 : -1;
                }
            }

            System.out.println("#" + testCase + " " + time);
        }
    }
}