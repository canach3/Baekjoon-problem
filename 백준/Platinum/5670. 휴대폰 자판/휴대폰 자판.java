import java.io.*;
import java.util.*;

public class Main {
    static Node root;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            root = new Node();

            int N = Integer.parseInt(input.trim());

            String[] words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine().trim();
                insert(words[i]);
            }

            double result = 0;
            for (int i = 0; i < N; i++) {
                result += search(words[i]);
            }

            result /= N;
            sb.append(String.format("%.2f", result)).append("\n");
        }

        System.out.print(sb);
    }

    static void insert(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            int alphabet = word.charAt(i) - 'a';

            if (current.children[alphabet] == null) {
                current.children[alphabet] = new Node();
                current.childCnt++;
            }
            current = current.children[alphabet];
        }

        current.endOfWord = true;
    }

    static int search(String word) {
        Node current = root.children[word.charAt(0) - 'a'];

        int result = 1;
        for (int i = 1; i < word.length(); i++) {
            int alphabet = word.charAt(i) - 'a';

            if (current.childCnt >= 2 || current.endOfWord) result++;

            current = current.children[alphabet];
        }

        return result;
    }

    static class Node {
        Node[] children;
        int childCnt;
        boolean endOfWord;

        Node() {
            this.children = new Node[26];
        }
    }
}