import java.util.*;

public class Main {

    static ArrayList<Node>[] trees;
    static boolean[] visited;
    static int max = 0;
    static int node;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        trees = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i < V + 1; i++) {
            trees[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            int from = sc.nextInt();

            while (true) {
                int to = sc.nextInt();
                if (to == -1) {
                    break;
                }

                int length = sc.nextInt();
                trees[from].add(new Node(to, length));
            }
        }

        dfs(1, 0);

        //node에서 부터 가장 먼 노트까지의 거리를 구한다.
        visited = new boolean[V + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for(int i = 0; i < trees[x].size(); i++) {
            Node n = trees[x].get(i);
            if(!visited[n.e]) {
                dfs(n.e, n.length + len);
                visited[n.e] = true;
            }
        }
    }
}
class Node {
    int e;
    int length;

    public Node(int e, int length) {
        this.e = e;
        this.length = length;
    }
}