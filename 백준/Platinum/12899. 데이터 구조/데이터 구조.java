import java.io.*;
import java.util.*;

public class Main {
    static Node[] roots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        roots = new Node[8];
        for (int i = 0; i < 8; i++) {
            roots[i] = new Node();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) insert(Integer.parseInt(st.nextToken()));
            if (command == 2) sb.append(delete(Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.print(sb);
    }

    static void insert(int num) {
        String numStr = String.valueOf(num);
        Node current = roots[numStr.length()];

        int digit = 0;
        while (digit < numStr.length()) {
            current.cnt++;

            int idx = numStr.charAt(digit) - '0';
            if (current.children[idx] == null) current.children[idx] = new Node();

            current = current.children[idx];
            digit++;
        }

        current.cnt++;
    }

    static String delete(int rank) {
        int digit = 1;
        for (; digit <= 7; digit++) {
            if (rank <= roots[digit].cnt) break;
            rank -= roots[digit].cnt;
        }

        Node current = roots[digit];
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= digit; i++) {
            current.cnt--;

            int num = 0;
            Node child = null;
            for (; num <= 9; num++) {
                child = current.children[num];

                if (child == null) continue;
                if (rank <= child.cnt) break;

                rank -= child.cnt;
            }

            result.append(num);
            current = child;
        }

        current.cnt--;

        return result.toString();
    }

    static class Node {
        int cnt;
        Node[] children;

        Node() {
            children = new Node[10];
        }
    }
}