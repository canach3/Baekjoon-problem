import java.io.*;
import java.util.*;

// https://www.grepiu.com/post/9
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int M = Integer.parseInt(strs[1]);
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();

        for(int i = 1; i <= N; i++) {
            String S = br.readLine();
            map1.put(i, S);
            map2.put(S, i);
        }

        for(int i = 0; i < M; i++) {
            String S = br.readLine();

            if(49 <= S.charAt(0) && S.charAt(0) <= 57) {
                sb.append(map1.get(Integer.parseInt(S))).append("\n");
            }else {
                sb.append(map2.get(S)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
