import java.util.*;

public class Main {
    static boolean[] visit;
    static boolean result = false;
    static int totalLevel = 4;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        list = new ArrayList[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 0);

            if (result) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    static void DFS(int num, int myLevel) {
        if (myLevel == totalLevel) {
            result = true;
            return;
        }

        visit[num] = true;

        for (int i = 0; i < list[num].size(); i++) {
            if (!visit[list[num].get(i)]) {
                DFS(list[num].get(i), myLevel + 1);
            }
        }

        visit[num] = false;
    }
}