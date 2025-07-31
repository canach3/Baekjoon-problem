import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> people = new ArrayList<>();
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            people.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            people.get(p1).add(p2);
            people.get(p2).add(p1);
        }

        int depth = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[j] = false;
            }

            depth = 1;

            DFS(i, depth);

            if (result) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void DFS(int person, int depth) {
        visited[person] = true;

        if (depth >= 5) {
            result = true;
            return;
        }

        for (int i = 0; i < people.get(person).size(); i++) {
            int friend = people.get(person).get(i);

            if (!visited[friend]) {
                DFS(friend, depth + 1);
                visited[friend] = false;
            }
        }
    }
}