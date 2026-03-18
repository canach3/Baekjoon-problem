import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connect = Integer.parseInt(st.nextToken());

                if (connect == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());

        for (int i = 1; i < M; i++) {
            int v2 = Integer.parseInt(st.nextToken());

            if (!union(v1, v2)) {
                System.out.println("NO");
                return;
            }
            
            v1 = v2;
        }

        System.out.println("YES");
    }

    static boolean union(int v1, int v2) {
        int v1Root = find(v1);
        int v2Root = find(v2);

        if (v1Root == v2Root) return true;

        parent[v2Root] = v1Root;
        return false;
    }

    static int find(int v) {
        if (parent[v] == v) return v;

        return parent[v] = find(parent[v]);
    }
}