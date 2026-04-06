import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        int N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String p1 = st.nextToken();
            String p2 = st.nextToken();

            if (set.contains(p1) || set.contains(p2)) {
                set.add(p1);
                set.add(p2);
            }
        }

        System.out.println(set.size());
    }
}