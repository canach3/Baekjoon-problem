import java.io.*;
import java.util.*;

public class Main {
    static Node root;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        root = new Node("");

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            String[] folders = br.readLine().split("\\\\");
            insert(folders);
        }

        sb = new StringBuilder();
        for (Node child : root.children.values()) {
            DFS(child, 0);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void insert(String[] folders) {
        Node current = root;
        int idx = 0;

        while (idx < folders.length) {
            String folder = folders[idx];
            Node child = current.children.get(folder);

            if (child == null){
                child = new Node(folder);
                current.children.put(folder, child);
            }

            current = child;
            idx++;
        }
    }

    static void DFS(Node current, int depth) {
        for (int i = 0; i < depth; i++) {
            sb.append(" ");
        }

        sb.append(current.name);

        for (Node child : current.children.values()) {
            sb.append("\n");
            DFS(child, depth + 1);
        }
    }

    static class Node implements Comparable<Node> {
        String name;
        TreeMap<String, Node> children;

        Node(String name) {
            this.name = name;
            this.children = new TreeMap<>();
        }

        @Override
        public int compareTo(Node o) {
            return name.compareTo(o.name);
        }
    }
}