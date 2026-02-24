import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        dfs(1, list);
    }

    static void dfs(int start, List<Integer> list){
        if(list.size() == M){
            StringBuilder sb = new StringBuilder();
            for(int num : list) sb.append(num).append(' ');
            System.out.println(sb);
            return;
        }

        for(int i = start; i <= N; i++){
            list.add(i);
            dfs(i, list);
            list.remove(list.size() - 1);
        }
    }
}