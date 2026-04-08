import java.io.*;
import java.util.*;

public class Main {
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        root = new Node();

        for (int i = 0; i < N; i++) {
            String word = br.readLine().trim();
            insert(word);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String prefix = br.readLine().trim();
            if (check(prefix)) cnt++;
        }

        System.out.println(cnt);
    }

    static void insert(String word) {
        Node current = root;

        int idx = 0;
        while (idx < word.length()) {
            int alphabet = word.charAt(idx) - 'a'; // 해당 인덱스의 알파벳 (0 ~ 25)

            Node child = current.children[alphabet];
            if (child == null) {
                child = new Node();
                current.children[alphabet] = child;
            }

            current = child;
            idx++;
        }

    }

    static boolean check(String prefix) {
        Node current = root;

        int idx = 0;
        while (idx < prefix.length()) {
            int alphabet = prefix.charAt(idx) - 'a'; // 해당 인덱스의 알파벳 (0 ~ 25)

            Node child = current.children[alphabet];
            if (child == null) return false;

            current = child;
            idx++;
        }

        return true;
    }

    static class Node {
        Node[] children;

        Node() {
            children = new Node[26];
        }
    }
}