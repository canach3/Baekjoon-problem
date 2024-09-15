import java.io.*;
import java.util.*;

// https://www.grepiu.com/post/9
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int card = sc.nextInt();
            if (map.containsKey(card)) {
                map.put(card, map.get(card) + 1);
            } else {
                map.put(card, 1);
            }
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int card = sc.nextInt();

            if (map.containsKey(card)) {
                sb.append(map.get(card)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
