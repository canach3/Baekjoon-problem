import java.io.*;
import java.util.*;

public class Solution {
    static StringBuilder sb;
    static int N;
    static char[] tree;

    public static void main(String[] args) throws  IOException{
//        System.setIn(new FileInputStream("res/input.txt"));

        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            sb.append("#").append(testCase).append(" ");

            N = Integer.parseInt(br.readLine().trim());

            tree = new char[N + 1];
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();

                char c = st.nextToken().charAt(0);
                tree[i] = c;
            }

            inorder(1);

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void inorder(int current) {
        if (current > N || tree[current] == '\u0000') return;

        inorder(current * 2);
        sb.append(tree[current]);
        inorder(current * 2 + 1);
    }
}