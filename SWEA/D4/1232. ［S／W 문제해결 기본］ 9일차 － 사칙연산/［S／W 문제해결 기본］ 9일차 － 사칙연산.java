import java.io.*;
import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static Node[] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine().trim());
            tree = new Node[N + 1];
            for (int i = 1; i <= N; i++) {
                tree[i] = new Node();
            }

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                String op = st.nextToken();

                switch(op.charAt(0)) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        tree[v].operator = op.charAt(0);
                        tree[v].left = Integer.parseInt(st.nextToken());
                        tree[v].right = Integer.parseInt(st.nextToken());
                        break;
                    default:
                        tree[v].operand = Integer.parseInt(op);
                        break;
                }
            }

            sb.append((int) inOrder(1));
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static class Node {
        int operand;
        char operator;
        int left;
        int right;
    }

    static double inOrder(int v) {
        if (tree[v].left == 0 && tree[v].right == 0) return tree[v].operand;

        if (tree[v].operator == '+') return inOrder(tree[v].left) + inOrder(tree[v].right);
        else if (tree[v].operator == '-') return inOrder(tree[v].left) - inOrder(tree[v].right);
        else if (tree[v].operator == '*') return inOrder(tree[v].left) * inOrder(tree[v].right);
        else return inOrder(tree[v].left) / inOrder(tree[v].right);
    }
}