import java.io.*;
import java.util.*;

public class Main {
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());


        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                set = new HashSet<>();
                continue;
            }

            if (set.contains(input)) continue;

            set.add(input);
            cnt++;
        }

        System.out.println(cnt);

    }
}