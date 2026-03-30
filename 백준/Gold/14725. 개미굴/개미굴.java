import java.io.*;
import java.util.*;

public class Main {
    static Node root;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        root = new Node();

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int depth = Integer.parseInt(st.nextToken());

            String[] words = new String[depth];
            for (int j = 0; j < depth; j++) {
                words[j] = st.nextToken();
            }

            insert(words);
        }

        sb = new StringBuilder();
        for (Node first : root.children.values()) {
            DFS(first, 0);
        }

        System.out.print(sb);
    }

    static void insert(String[] words) {
        Node current = root;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            Node child = current.children.get(word);
            if (child == null) {
                child = new Node();
                child.word = word;
                current.children.put(word, child);
            }

            current = child;
        }
    }

    static void DFS(Node current, int level) {
        // 자기 자신 출력
        for (int i = 0; i < level * 2; i++) {
            sb.append("-");
        }
        sb.append(current.word).append("\n");

        // 자식 탐색
        for (Node child : current.children.values()) {
            DFS(child, level + 1);
        }
    }

    static class Node {
        String word;
        TreeMap<String, Node> children;

        Node() {
            children = new TreeMap<>();
        }
    }
}