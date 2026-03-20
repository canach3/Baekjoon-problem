import java.io.*;
import java.util.*;

public class Main {
    static Node root;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            root = new Node();

            boolean isConsistent = true;
            int N = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                String phoneNumber = br.readLine();

                if (!isConsistent) continue;
                if (!insert(phoneNumber)) isConsistent = false;
            }

            sb.append(isConsistent ? "YES" : "NO");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static class Node {
        Node[] children;
        boolean endOfWord;

        Node () {
            children = new Node[10];
        }
    }

    static boolean insert(String phoneNumber) {
        Node current = root;

        for (int i = 0; i < phoneNumber.length(); i++) {
            int num = phoneNumber.charAt(i) - '0';

            // 해당 번호가 없는 경우
            if (current.children[num] == null) {
                current.children[num] = new Node();
            }

            current = current.children[num];

            // 나는 안 끝났는데, 해당 번호가 접두어로 존재하는 경우
            if (current.endOfWord) return false;
        }

        // 마지막엔 끝을 의미하는 endOfWord 처리
        current.endOfWord = true;

        // 나는 끝났는데, 나를 접두어로하는 번호가 존재하는 경우
        for (int i = 0; i <= 9; i++) {
            if (current.children[i] != null) return false;
        }

        return true;
    }
}