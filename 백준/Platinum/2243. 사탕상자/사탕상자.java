import java.io.*;
import java.util.*;

public class Main {
    static Node[] roots; // 맛 자릿수별 root


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        roots = new Node[8];
        for (int i = 1; i <= 7; i++) {
            roots[i] = new Node();
        }

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    sb.append(search(Integer.parseInt(st.nextToken()))).append("\n");
                    break;
                case 2:
                    int taste = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    insert(taste, cnt);
                    break;
            }
        }

        System.out.print(sb);
    }

    static void insert(int taste, int cnt) {
        String tasteStr = String.valueOf(taste);
        Node current = roots[tasteStr.length()];

        int idx = 0;
        while (idx < tasteStr.length()) {
            current.cnt += cnt;

            int num = tasteStr.charAt(idx++) - '0';

            if (current.children[num] == null) {
                current.children[num] = new Node();
            }

            current = current.children[num];
        }

        current.cnt += cnt;
    }

    static int search(int rank) {
        // 자기보다 낮은 사탕의 개수를 세고 +1 반환

        int digit = 1;
        while (rank > roots[digit].cnt) {
            rank -= roots[digit++].cnt;
        }

        Node current = roots[digit];
        StringBuilder taste = new StringBuilder();

        for (int i = 1; i <= digit; i++) {
            current.cnt--;

            int idx = 0;
            for (; idx <= 9; idx++) {
                if (current.children[idx] == null) continue;

                int amount = current.children[idx].cnt;

                if (amount < rank) rank -= amount;
                else break;
            }

            current = current.children[idx];
            taste.append(idx);
        }

        current.cnt--;

        return Integer.parseInt(taste.toString());
    }

    static class Node {
        int cnt;
        Node[] children;

        Node() {
            children = new Node[10];
        }
    }
}